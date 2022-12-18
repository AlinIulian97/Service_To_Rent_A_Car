package beams.model.branch;

import beams.model.employee.EmployeeResponse;
import lombok.Data;

import java.util.List;

@Data
public class BranchDetailsResponse {

    private Integer id;
    private String addressCity;
    private List<EmployeeResponse> employees;



}
