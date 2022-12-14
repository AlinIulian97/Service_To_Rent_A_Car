package beams.model.employee;

import beams.entity.enums.EmployeeEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class EmployeeResponse {

    private Integer id;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    EmployeeEnum type ;
}
