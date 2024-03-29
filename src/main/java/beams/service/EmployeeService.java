package beams.service;

import beams.interfacesForToGet.GetList;
import beams.entity.Employee;
import beams.exception.BusinessException;
import beams.mapper.EmployeeMapper;
import beams.model.employee.EmployeeRequest;
import beams.model.employee.EmployeeResponse;
import beams.model.employee.EmployeeUpdateResponse;
import beams.repository.BranchRepository;
import beams.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;

import static beams.entity.enums.EmployeeEnum.*;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService implements GetList<EmployeeResponse> {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    private final BranchRepository branchRepository;

    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.map(employeeRequest);
        employee.setBranch(branchRepository.findById(employeeRequest.getBranchId()).orElseThrow(
                () -> new BusinessException("Branch not found")));
        employeeRepository.save(employee);
        return employeeMapper.map(employee);
    }

    public void deleteEmployee(Integer id) {
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow(
                () -> new BusinessException("Employee not found")
        );
        employeeRepository.delete(employeeToDelete);
    }

    public List<EmployeeResponse> employees() {
        return employeeMapper.map(employeeRepository.findAll());
    }

    public EmployeeResponse findById(Integer id) {
        return employeeMapper.map(employeeRepository.findById(id).orElseThrow(
                () -> new BusinessException("Empolyee not found")
        ));
    }

    public void updateEmployee(Integer id, EmployeeUpdateResponse employeeUpdateResponse) {
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(
                () -> new BusinessException("Employee not found"));
        employeeToUpdate.setBranch(branchRepository.findById(employeeUpdateResponse.getBranchId()).orElseThrow(
                () -> new BusinessException("Branch not found")));

        employeeUpdateResponse.setBranch(employeeToUpdate.getBranch());
    }

    public Boolean ExistManager() {
        for (EmployeeResponse employeeResponse : employees()) {
            if (String.valueOf(employeeResponse.getType()).equals("MANAGER")) {
                return true;
            }
        }
        return false;
    }

    public Boolean ExistManagerStream(){
        return employees()
                .stream()
                .anyMatch(employeeResponse
                        -> employeeResponse.getType() == MANAGER);
    }

    public Integer ManagerIdFound(EmployeeRequest employeeRequest) {
        for (EmployeeResponse employeeResponse : employees()) {
            if (String.valueOf(employeeResponse.getType()).equals("MANAGER") && employeeResponse.getBranchId() == employeeRequest.getBranchId()) {
                return employeeResponse.getBranchId();
            }
        }
        return null;
    }

    @Override
    public List<EmployeeResponse> getAllList() {
        return employeeMapper.map(employeeRepository.findAll());
    }

    @Override
    public Function<Integer, EmployeeResponse> findByIdInterfaces() {
        return id -> employees()
                .stream()
                .filter(employeeResponse
                        -> employeeResponse.getId().equals(id))
                .findFirst()
                .orElseThrow(()
                        -> new BusinessException("No match"));

    }

}
