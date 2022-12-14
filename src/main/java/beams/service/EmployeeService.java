package beams.service;

import beams.entity.Employee;
import beams.mapper.EmployeeMapper;
import beams.model.employee.EmployeeRequest;
import beams.model.employee.EmployeeResponse;
import beams.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest){
        Employee employee=employeeMapper.map(employeeRequest);
        return employeeMapper.map(employeeRepository.save(employee));

    }
}
