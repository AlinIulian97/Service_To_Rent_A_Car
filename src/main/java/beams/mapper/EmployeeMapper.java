package beams.mapper;

import beams.entity.Employee;
import beams.model.employee.EmployeeRequest;
import beams.model.employee.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper
public interface EmployeeMapper {

    Employee map(EmployeeRequest employeeRequest);

    @Mapping(target = "branchId", source = "branch.id")
    EmployeeResponse map(Employee employee);


    List<EmployeeResponse> map(List<Employee> employees);

}
