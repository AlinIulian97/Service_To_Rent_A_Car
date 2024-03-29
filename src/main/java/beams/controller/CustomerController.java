package beams.controller;

import beams.model.customer.CustomerRequest;
import beams.model.customer.CustomerResponse;
import beams.model.customer.UpdateCustomerResponse;
import beams.model.employee.EmployeeResponse;
import beams.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping("/save")
    public CustomerResponse saveCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        return customerService.saveCustomer(customerRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable  Integer id){
        customerService.deleteCustomer(id);
    }

    @PatchMapping("{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody UpdateCustomerResponse customerUpdateResponse) {
        customerService.updateCustomer(customerUpdateResponse, id);
    }

    @GetMapping("{id}")
    public CustomerResponse findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    @GetMapping("/list")
    public List<CustomerResponse> customers(){
        return customerService.customers();
    }
}


