package beams.model.employee;


import beams.entity.enums.EmployeeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class EmployeeRequest {

    private Integer id;

    @NotBlank(message = "INVALID FIRST NAME")
    private String firstName;

    @NotBlank(message = "INVALID LAST NAME")
    private String lastName;

    @Enumerated(EnumType.STRING)
    EmployeeEnum type ;
}
