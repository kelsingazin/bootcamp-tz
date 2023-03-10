package kz.kelsingazin.bootcamp.shared.utils.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import kz.kelsingazin.bootcamp.shared.utils.codes.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    
    @JsonProperty("status")
    private String status = "error";

    @JsonProperty("code")
    private ErrorCode code;

    @JsonProperty("message")
    private String message;
    
}
