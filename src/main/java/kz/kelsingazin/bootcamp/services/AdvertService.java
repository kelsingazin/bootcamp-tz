package kz.kelsingazin.bootcamp.services;

import kz.kelsingazin.bootcamp.models.entities.Advert;

public interface AdvertService {
    Advert create(Advert advert);

    Advert bet(Long advertId, Long productId, Long userId, Double price);
}
