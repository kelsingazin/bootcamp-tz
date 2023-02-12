package kz.kelsingazin.bootcamp.models.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @ApiModelProperty(notes = "Имя", readOnly = true)
    private String title;

    @ApiModelProperty(notes = "Описание", readOnly = true)
    private String description;

    @ApiModelProperty(notes = "Цена", readOnly = true)
    private Double price;

    private UserDto userDto;
}
