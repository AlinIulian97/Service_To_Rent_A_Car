package beams.controller;

import beams.model.customer.CustomerRequest;
import beams.model.customer.CustomerResponse;
import beams.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping("/saveCustomer")
    public CustomerResponse saveCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        return customerService.saveCustomer(customerRequest);
    }


}
