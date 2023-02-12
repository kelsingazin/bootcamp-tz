package kz.kelsingazin.bootcamp.controllers;

import kz.kelsingazin.bootcamp.controllers.base.BaseController;
import kz.kelsingazin.bootcamp.models.mappers.AdvertMapper;
import kz.kelsingazin.bootcamp.services.AdvertService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prodcuts")
@AllArgsConstructor
public class AdvertController extends BaseController {

    private final AdvertService advertService;
    private final AdvertMapper advertMapper;


}
