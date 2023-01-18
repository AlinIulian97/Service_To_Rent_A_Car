package beams.model.branch;

import beams.model.rental.RentalResponseForBranch;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchRequest {

    private Integer id;

    private String addressCity;

    private Integer rentalId;

    private RentalResponseForBranch rentalResponseForBranch;

}
