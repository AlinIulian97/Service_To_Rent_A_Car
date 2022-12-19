package beams.controller;

import beams.model.employee.EmployeeRequest;
import beams.model.employee.EmployeeResponse;
import beams.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
