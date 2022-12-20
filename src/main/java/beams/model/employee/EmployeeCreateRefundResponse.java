package beams.model.employee;

import beams.entity.enums.EmployeeEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
public class EmployeeCreateRefundResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private EmployeeEnum type;


}
