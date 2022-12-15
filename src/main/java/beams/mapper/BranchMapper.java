package beams.mapper;

import beams.entity.Branch;
import beams.model.branch.BranchRequest;
import beams.model.branch.BranchResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@Mapper(componentModel = "spring")
public interface BranchMapper {

    Branch map(BranchRequest branchRequest);

    BranchResponse map(Branch branch);




}
