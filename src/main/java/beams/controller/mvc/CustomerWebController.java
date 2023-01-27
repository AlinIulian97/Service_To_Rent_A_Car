package beams.controller.mvc;

import beams.model.car.CarRequest;
import beams.model.customer.CustomerRequest;
import beams.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CustomerWebController {
    private final CustomerService customerService;

    @GetMapping("/customerPage")
    public String goToCustomerPage() {
        return "customerPage";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute(value = "createCustomer")
                                 CustomerRequest request,
                                 Model model) {
        CustomerRequest customerRequest = CustomerRequest.builder()
                .firstName(request.getFirstName())
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .build();
        customerService.saveCustomer(customerRequest);
        model.addAttribute("customers", customerService.customers());
        return "allCustomers";
    }

    @GetMapping("/viewCustomers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.customers());
        return "allCustomers";
    }

    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@ModelAttribute("deleteRequest")
                            CustomerRequest customerRequest,
                            Model model) {

        customerService.deleteCustomer(customerRequest.getId());
        model.addAttribute("customers", customerService.customers());
        return "allCustomers";
    }
}
