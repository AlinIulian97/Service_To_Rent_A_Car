package beams.model.branch;

import beams.model.rental.RentalResponseForBranch;
import lombok.Data;

@Data
public class BranchResponse {

    private Integer id;

    private String addressCity;

    private RentalResponseForBranch rentalResponseForBranch;
}
