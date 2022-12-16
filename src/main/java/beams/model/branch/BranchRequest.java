package beams.model.branch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class BranchRequest {

    private Integer id;

    private String addressCity;

    private Integer rentalId;

}
