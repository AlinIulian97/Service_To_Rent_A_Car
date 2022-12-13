package beams.controller;

import beams.entity.Customer;
import beams.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping("/saveCustomer")
    public void saveCustomer(@RequestBody  Customer customer){
        customerService.saveCustomer(customer);
    }


}
