package kz.kelsingazin.bootcamp.repositories;

import kz.kelsingazin.bootcamp.models.entities.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

    Optional<Advert> findAdvertByIdAndDeletedAtNull(Long id);
}
