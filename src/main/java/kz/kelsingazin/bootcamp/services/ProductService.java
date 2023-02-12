package kz.kelsingazin.bootcamp.services;

import kz.kelsingazin.bootcamp.models.entities.Product;

import java.util.List;

public interface ProductService {

    Product getActiveProductById(Long id);

    List<Product> getAllActiveProducts();

    List<Product> getAllInactiveProducts();

    Product create(Product product);
}
