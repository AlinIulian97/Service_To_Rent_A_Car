package beams.controller.mvc;

import beams.entity.enums.EmployeeEnum;
import beams.exception.BusinessException;
import beams.model.employee.EmployeeRequest;
import beams.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class EmployeeWebController {
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
        if(employeeRequest.getType() == EmployeeEnum.EMPLOYEE){
            employeeService.saveEmployee(employeeRequest);
            model.addAttribute("employees" , employeeService.employees());
        return "allEmployeePage";
        }
        if (employeeService.ExistManager() && Objects.equals(employeeService.ManagerIdFound(employeeRequest), employeeRequest.getBranchId())){
            throw new BusinessException("Manager already exist in this branch");
        } employeeService.saveEmployee(employeeRequest);

        model.addAttribute("employees" , employeeService.employees());
        return "allEmployeePage";
    }

    @GetMapping("/allEmployees")
    public String getAllEmployee(Model model){
        model.addAttribute("employees" , employeeService.employees());
    return "allEmployeePage";
    }

}
