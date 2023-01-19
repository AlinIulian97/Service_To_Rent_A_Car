package beams.mapper;

import beams.entity.Branch;
import beams.model.branch.BranchDetailsResponse;
import beams.model.branch.BranchRequest;
import beams.model.branch.BranchResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(uses = {EmployeeMapper.class})
public interface BranchMapper {

    Branch map(BranchRequest branchRequest);
    @Mapping(target = "rentalId", source = "rental.id")
    BranchResponse map(Branch branch);

    BranchDetailsResponse mapDetails(Branch branch);

    List<BranchResponse> map(List<Branch> branches);


}
