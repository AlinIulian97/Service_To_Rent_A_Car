package beams.model.customer;

import lombok.Data;

@Data
public class CreateCustomerRequest {

    private String firstName;
    private String name;
    private String email;
    private String address;
}
