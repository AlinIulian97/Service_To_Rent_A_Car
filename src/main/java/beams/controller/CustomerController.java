package beams.controller;

import beams.model.customer.CustomerRequest;
import beams.model.customer.CustomerResponse;
import beams.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public CustomerResponse saveCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.saveCustomer(customerRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }
}
