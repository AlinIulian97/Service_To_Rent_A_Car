package beams.controller.mvc;

import beams.model.employee.EmployeeRequest;
import beams.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EmployeePage {
private final EmployeeService employeeService;

    @GetMapping("/employeePage")
    public String goToEmployeePage(){
        return "employeePage";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@ModelAttribute(value = "createEmployee")
                                 EmployeeRequest request,
                                 Model model){
        EmployeeRequest employeeRequest = EmployeeRequest.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .branchId(request.getBranchId())
                .type(request.getType())
                .build();
        employeeService.saveEmployee(employeeRequest);

        model.addAttribute("employees" , employeeService.employees());
        return "allEmployeePage";
    }

    @GetMapping("/allEmployees")
    public String getAllEmployee(Model model){
        model.addAttribute("employees" , employeeService.employees());
    return "allEmployeePage";
    }

}
