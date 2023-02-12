package kz.kelsingazin.bootcamp.exceptions;


import kz.kelsingazin.bootcamp.shared.utils.codes.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceException extends RuntimeException {

    protected String message;
    protected ErrorCode errorCode;

}
