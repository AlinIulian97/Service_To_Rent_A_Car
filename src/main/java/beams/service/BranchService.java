package beams.service;

import beams.entity.Branch;
import beams.exception.BusinessException;
import beams.mapper.BranchMapper;
import beams.mapper.CarMapper;
import beams.model.branch.BranchDetailsResponse;
import beams.model.branch.BranchRequest;
import beams.model.branch.BranchResponse;
import beams.model.branch.BranchToUpdate;
import beams.repository.BranchRepository;
import beams.repository.EmployeeRepository;
import beams.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;
    private final RentalRepository rentalRepository;



    public BranchResponse saveBranch(BranchRequest branchRequest) {

        Branch branchToSave = branchMapper.map(branchRequest);

        branchToSave.setRental(rentalRepository.findById(branchRequest.getRentalId()).orElseThrow(
                () -> new BusinessException("Rental ont found")
        ));

        branchRepository.save(branchToSave);
        return branchMapper.map(branchToSave);
    }

    public BranchResponse findById(Integer id) {
        return branchMapper.map(branchRepository.findById(id).orElseThrow(
                () -> new BusinessException("No branch found")
        ));
    }

    public BranchDetailsResponse findByIdWithDetails(Integer id) {
        return branchMapper.mapDetails(branchRepository.findById(id).orElseThrow(
                () -> new BusinessException("No branch found")
        ));
    }

    public void updateBranch(Integer id, BranchToUpdate branchToUpdate) {
        Branch branch = branchRepository.findById(id).orElseThrow(
                () -> new BusinessException("No branch found")
        );
        branch.setAddressCity(branchToUpdate.getAddressCity());
    }

    public void deleteBranch(Integer id) {
        Branch branch = branchRepository.findById(id).orElseThrow(
                () -> new BusinessException("Not found"));
        branchRepository.delete(branch);
    }

    public List<BranchResponse> branches() {
        return branchMapper.map(branchRepository.findAll());
    }

    public List<BranchResponse> availableCarsInBranchSelected(String address) {
        List<BranchResponse> list = new ArrayList<>();
        for (BranchResponse branchResponse : branches()) {
            if (branchResponse.getAddressCity().equals(address)) {
                list.add(branchResponse);
            }
        }
        return list;
    }

    public List<BranchResponse> availableCarsInBranchSelectedStream(String address){
        return branches()
                .stream()
                .filter(branchResponse -> branchResponse.getAddressCity().equals(address))
                .toList();
    }
}








