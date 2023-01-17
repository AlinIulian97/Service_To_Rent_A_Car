package beams.controller;

import beams.entity.Employee;
import beams.model.employee.EmployeeRequest;
import beams.model.employee.EmployeeResponse;
import beams.model.employee.EmployeeUpdateResponse;
import beams.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save")
    public EmployeeResponse saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.saveEmployee(employeeRequest);
    }

    @DeleteMapping("/{id}")
    public void EmployeeToDelete(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }


    @GetMapping("{id}")
    public EmployeeResponse findById(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    @PatchMapping("{id}")
    public void updateEmployee(@PathVariable Integer id, @RequestBody EmployeeUpdateResponse employeeUpdateResponse) {
        employeeService.updateEmployee(id, employeeUpdateResponse);
    }

    @GetMapping("/list")
    public List<EmployeeResponse> getAllEmployee(){
      return employeeService.employees();
    }
}
