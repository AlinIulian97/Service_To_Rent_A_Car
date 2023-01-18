package beams.mapper;


import beams.entity.Car;
import beams.entity.Customer;
import beams.model.customer.CustomerRequest;
import beams.model.customer.CustomerResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer map(CustomerRequest customerRequest);

    CustomerResponse map(Customer customer);

    List<CustomerResponse> map(List<Customer> customer);


}
