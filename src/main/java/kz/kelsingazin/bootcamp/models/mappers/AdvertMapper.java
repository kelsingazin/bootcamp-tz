package kz.kelsingazin.bootcamp.models.mappers;

import kz.kelsingazin.bootcamp.models.dtos.AdvertDto;
import kz.kelsingazin.bootcamp.models.dtos.ProductDto;
import kz.kelsingazin.bootcamp.models.entities.Advert;
import kz.kelsingazin.bootcamp.models.entities.Product;
import kz.kelsingazin.bootcamp.shared.utils.mappers.AbstractModelMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdvertMapper extends AbstractModelMapper<Advert, AdvertDto> {

    private final ModelMapper modelMapper;

    @Override
    public AdvertDto toDto(Advert advert) {
        AdvertDto advertDto = modelMapper.map(advert, AdvertDto.class);
        return advertDto;
    }

    @Override
    public Advert toEntity(AdvertDto advertDto) {
        Advert advert = modelMapper.map(advertDto, Advert.class);
        return advert;
    }

    @Override
    public List<AdvertDto> toDtoList(List<Advert> adverts) {
        return adverts.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Advert> toEntityList(List<AdvertDto> advertDtos) {
        return advertDtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
