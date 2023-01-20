package beams.model.rental;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RentalResponse {
    private Integer id;
    private String internetDomain;
    private String nameRental;
    private String contactAddress;
    private String owner;
    private String logoType;


}
