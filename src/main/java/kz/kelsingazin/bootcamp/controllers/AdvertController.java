package kz.kelsingazin.bootcamp.controllers;

import io.swagger.annotations.ApiOperation;
import kz.kelsingazin.bootcamp.controllers.base.BaseController;
import kz.kelsingazin.bootcamp.models.dtos.AdvertDto;
import kz.kelsingazin.bootcamp.models.entities.Advert;
import kz.kelsingazin.bootcamp.models.mappers.AdvertMapper;
import kz.kelsingazin.bootcamp.services.AdvertService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/adverts")
@AllArgsConstructor
public class AdvertController extends BaseController {

    private final AdvertService advertService;
    private final AdvertMapper advertMapper;

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Создание объявления")
    public ResponseEntity<?> create(@RequestBody AdvertDto advertDto) {
        Advert advert = advertMapper.toEntity(advertDto);
        Advert createdAdvert = advertService.create(advert);
        return buildResponse(advertMapper.toDto(createdAdvert), HttpStatus.OK);
    }

    @PostMapping(value = "/{advertId}",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation("Создание объявления")
    public ResponseEntity<?> bet(@PathVariable Long advertId,
                                 @RequestParam Long productId,
                                 @RequestParam Long userId,
                                 @RequestParam Double price) {
        Advert createdAdvert = advertService.bet(advertId, productId, userId, price);
        return buildResponse(advertMapper.toDto(createdAdvert), HttpStatus.OK);
    }
}
