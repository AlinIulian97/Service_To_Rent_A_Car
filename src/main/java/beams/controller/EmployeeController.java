package beams.controller;

import beams.entity.Employee;
import beams.model.employee.EmployeeRequest;
import beams.model.employee.EmployeeResponse;
import beams.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public EmployeeResponse saveEmployee(@RequestBody EmployeeRequest employeeRequest){
      return  employeeService.saveEmployee(employeeRequest);
    }
}
