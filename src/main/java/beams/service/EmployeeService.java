package beams.service;

import beams.entity.Branch;
import beams.entity.Employee;
import beams.exception.BusinessException;
import beams.mapper.EmployeeMapper;
import beams.model.employee.EmployeeRequest;
import beams.model.employee.EmployeeResponse;
import beams.repository.BranchRepository;
import beams.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    private final BranchRepository branchRepository;

    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest){
        Employee employee=employeeMapper.map(employeeRequest);
        employee.setBranch(branchRepository.findById(employeeRequest.getBranchId()).orElseThrow(
                ()-> new BusinessException("Branch not found")));
        employeeRepository.save(employee);
        return employeeMapper.map(employee);
    }

    public void deleteEmployee(Integer id){
        Employee employeeToDelete =employeeRepository.findById(id).orElseThrow(
                () -> new BusinessException("Employee not found")
        );
        employeeRepository.delete(employeeToDelete);
    }

    public List<EmployeeResponse> employees(){
        return employeeMapper.map(employeeRepository.findAll());
    }
}
