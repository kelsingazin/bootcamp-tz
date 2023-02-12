package kz.kelsingazin.bootcamp.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kz.kelsingazin.bootcamp.controllers.base.BaseController;
import kz.kelsingazin.bootcamp.models.dtos.ProductDto;
import kz.kelsingazin.bootcamp.models.entities.Product;
import kz.kelsingazin.bootcamp.models.mappers.ProductMapper;
import kz.kelsingazin.bootcamp.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prodcuts")
@AllArgsConstructor
public class ProductController extends BaseController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping(value = "{id}",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Получение всех активных пользователей")
    public ResponseEntity<?> getActiveProductById(@ApiParam("ID элемента") @PathVariable Long id) {
        Product activeProductById = productService.getActiveProductById(id);
        return buildResponse(productMapper.toDto(activeProductById), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Создание продукта")
    public ResponseEntity<?> create(@RequestBody ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product createdProduct = productService.create(product);
        return buildResponse(productMapper.toDto(createdProduct), HttpStatus.OK);
    }

    @GetMapping(value = "/active",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllActiveProducts() {
        List<Product> products = productService.getAllActiveProducts();
        return buildResponse(productMapper.toDtoList(products), HttpStatus.OK);
    }

    @GetMapping(value = "/inactive",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllInactiveProducts() {
        List<Product> products = productService.getAllInactiveProducts();
        return buildResponse(productMapper.toDtoList(products), HttpStatus.OK);
    }
}
