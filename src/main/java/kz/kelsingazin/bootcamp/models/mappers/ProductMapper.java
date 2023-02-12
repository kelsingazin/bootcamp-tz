package kz.kelsingazin.bootcamp.models.mappers;

import kz.kelsingazin.bootcamp.models.dtos.ProductDto;
import kz.kelsingazin.bootcamp.models.entities.Product;
import kz.kelsingazin.bootcamp.shared.utils.mappers.AbstractModelMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper extends AbstractModelMapper<Product, ProductDto> {

    private final ModelMapper modelMapper;

    @Override
    public ProductDto toDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    @Override
    public Product toEntity(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return product;
    }

    @Override
    public List<ProductDto> toDtoList(List<Product> products) {
        return products.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> toEntityList(List<ProductDto> productDtos) {
        return productDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
