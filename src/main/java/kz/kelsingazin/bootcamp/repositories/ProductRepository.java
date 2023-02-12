package kz.kelsingazin.bootcamp.repositories;

import kz.kelsingazin.bootcamp.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByIdAndDeletedAtNull(Long id);
    Optional<List<Product>> findAllByDeletedAtNull();
    Optional<List<Product>> findAllByDeletedAtNotNull();
}
