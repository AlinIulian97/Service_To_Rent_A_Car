package beams.model.rental;

import beams.entity.Branch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

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
