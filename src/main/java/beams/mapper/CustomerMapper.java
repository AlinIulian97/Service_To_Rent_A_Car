package beams.mapper;


import beams.entity.Car;
import beams.entity.Customer;
import beams.model.customer.CustomerRequest;
import beams.model.customer.CustomerResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer map(CustomerRequest customerRequest);

    CustomerResponse map(Customer customer);


}
