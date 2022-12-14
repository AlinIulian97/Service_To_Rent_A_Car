package beams.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CustomerRequest {

    private Integer id;

    @NotBlank(message = "INVALID FIRST NAME")
    private String firstName;

    @NotBlank(message = "INVALID NAME")
    private String name;

    @NotBlank(message = "INVALID EMAIL")
    private String email;

    @NotBlank(message = "INVALID ADDRESS")
    private String address;


}
