package kz.kelsingazin.bootcamp.services.impl;

import kz.kelsingazin.bootcamp.exceptions.ServiceException;
import kz.kelsingazin.bootcamp.models.entities.Product;
import kz.kelsingazin.bootcamp.repositories.ProductRepository;
import kz.kelsingazin.bootcamp.services.ProductService;
import kz.kelsingazin.bootcamp.shared.utils.codes.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getActiveProductById(Long id) {
        log.info("Get product by id " + id);
        return productRepository.findProductByIdAndDeletedAtNull(id)
                .orElseThrow(() -> ServiceException.builder()
                        .errorCode(ErrorCode.USER_NOT_FOUND)
                        .message("Пользователь не найден").build());
    }

    @Override
    public List<Product> getAllActiveProducts() {
        log.info("Get all active products");
        return productRepository.findAllByDeletedAtNull()
                .orElseThrow(() -> ServiceException.builder()
                        .errorCode(ErrorCode.PRODUCT_NOT_FOUND)
                        .message("Пользователь не найден").build());
    }

    @Override
    public List<Product> getAllInactiveProducts() {
        log.info("Get all inactive products");
        return productRepository.findAllByDeletedAtNotNull()
                .orElseThrow(() -> ServiceException.builder()
                        .errorCode(ErrorCode.PRODUCT_NOT_FOUND)
                        .message("Пользователь не найден").build());
    }

    @Override
    public Product create(Product product) {
        log.info("Create a product");
        if(productRepository.findById(product.getId()).isPresent()){
            throw ServiceException.builder()
                    .errorCode(ErrorCode.ALREADY_EXISTS)
                    .message("Продукт уже есть")
                    .build();
        }
        return productRepository.save(product);
    }
}
