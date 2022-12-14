package beams.mapper;

import beams.entity.Employee;
import beams.model.employee.EmployeeRequest;
import beams.model.employee.EmployeeResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee map(EmployeeRequest employeeRequest);

    EmployeeResponse map(Employee employee);



}
