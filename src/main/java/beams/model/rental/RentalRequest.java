package beams.model.rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class RentalRequest {

    private Integer id;

    @NotBlank(message = "INVALID INTERNET DOMAIN")
    private String internetDomain;

    @NotBlank(message = "INVALID NAME RENTAL")
    private String nameRental;

    @NotBlank(message = "INVALID CONTACT ADDRESS")
    private String contactAddress;

    @NotBlank(message = "INVALID OWNER")
    private String owner;

    @NotBlank(message = "INVALID LOGO TYPE")
    private String logoType;

}
