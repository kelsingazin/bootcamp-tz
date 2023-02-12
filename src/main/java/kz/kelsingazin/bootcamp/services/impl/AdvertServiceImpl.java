package kz.kelsingazin.bootcamp.services.impl;

import kz.kelsingazin.bootcamp.exceptions.ServiceException;
import kz.kelsingazin.bootcamp.models.entities.Advert;
import kz.kelsingazin.bootcamp.models.entities.Product;
import kz.kelsingazin.bootcamp.models.entities.User;
import kz.kelsingazin.bootcamp.repositories.AdvertRepository;
import kz.kelsingazin.bootcamp.services.AdvertService;
import kz.kelsingazin.bootcamp.services.ProductService;
import kz.kelsingazin.bootcamp.services.UserService;
import kz.kelsingazin.bootcamp.shared.utils.codes.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;
    private final UserService userService;
    private final ProductService productService;

    @Override
    public Advert create(Advert advert) {
        log.info("Create an advert");
        Advert activeAdvert = findActiveAdvert(advert.getId());
        activeAdvert.setEndedAt(new Date(System.currentTimeMillis() + (600 * 100))); //10 mins
        return advertRepository.save(advert);
    }

    @Override
    public Advert bet(Long advertId, Long productId, Long userId, Double price) {
        User user = userService.getActiveUserById(userId);
        Product product = productService.getActiveProductById(productId);
        if(price<= product.getPrice()){
            throw ServiceException.builder()
                    .errorCode(ErrorCode.PRODUCT_NOT_FOUND)
                    .message("Ставка должна быть больше текушей")
                    .build();
        }else {
            product.setPrice(price);
        }
        Advert advert = findActiveAdvert(advertId);
        if(advert.getEndedAt().before(new Date())){
            log.info("Auction is over!");
            log.info("Send email to buyer -> " + advert.getBuyerId());
            log.info("Send email to seller -> " + advert.getSellerId());
            throw ServiceException.builder()
                    .errorCode(ErrorCode.AUCTION_IS_OVER)
                    .message("Ставки больше не принимаются. Продажа закрыта")
                    .build();
        }
        advert.setUpdatedAt(new Date());
        advert.setProduct(product);
        advert.setBuyerId(user);
        return advertRepository.save(advert);
    }

    private Advert findActiveAdvert(Long id) {
        return advertRepository.findAdvertByIdAndDeletedAtNull(id)
                .orElseThrow(() -> ServiceException.builder()
                .errorCode(ErrorCode.ALREADY_EXISTS)
                .message("Продукт уже есть")
                .build());
    }
}
