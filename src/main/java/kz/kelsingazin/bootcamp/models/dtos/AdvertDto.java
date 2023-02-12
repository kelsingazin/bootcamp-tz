package kz.kelsingazin.bootcamp.models.dtos;


import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertDto {

    @ManyToOne
    @ApiModelProperty(notes = "Продавец", readOnly = true)
    private UserDto sellerId;

    @ManyToOne
    @ApiModelProperty(notes = "Покупатель", readOnly = true)
    private UserDto buyerId;

    @ManyToOne
    @ApiModelProperty(notes = "Продукт", readOnly = true)
    private ProductDto product;
}
