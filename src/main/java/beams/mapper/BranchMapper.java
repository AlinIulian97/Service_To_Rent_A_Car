package beams.mapper;

import beams.entity.Branch;
import beams.model.branch.BranchDetailsResponse;
import beams.model.branch.BranchRequest;
import beams.model.branch.BranchResponse;
import org.mapstruct.Mapper;


@Mapper(uses = {EmployeeMapper.class})
public interface BranchMapper {

    Branch map(BranchRequest branchRequest);

    BranchResponse map(Branch branch);

    BranchDetailsResponse mapDetails(Branch branch);




}
