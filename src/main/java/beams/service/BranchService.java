package beams.service;

import beams.entity.Branch;
import beams.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;

    public void saveBranch(Branch branch){
        branchRepository.save(branch);
    }

}
