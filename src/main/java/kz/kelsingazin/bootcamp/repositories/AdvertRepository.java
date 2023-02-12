package kz.kelsingazin.bootcamp.repositories;

import kz.kelsingazin.bootcamp.models.entities.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {
}
