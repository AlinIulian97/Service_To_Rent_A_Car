package beams.service;

import beams.entity.Branch;
import beams.exception.BusinessException;
import beams.mapper.BranchMapper;
import beams.model.branch.BranchDetailsResponse;
import beams.model.branch.BranchRequest;
import beams.model.branch.BranchResponse;
import beams.model.employee.EmployeeResponse;
import beams.model.rental.RentalResponseForBranch;
import beams.repository.BranchRepository;
import beams.repository.EmployeeRepository;
import beams.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public BranchResponse saveBranch(BranchRequest branchRequest) {

        Branch branchToSave = branchMapper.map(branchRequest);

        branchToSave.setRental(rentalRepository.findById(branchRequest.getRentalId()).orElseThrow(
                () -> new BusinessException("Rental ont found")
        ));

        branchRepository.save(branchToSave);

        BranchResponse branchResponse = new BranchResponse();
        branchResponse.setId(branchToSave.getId());
        branchResponse.setAddressCity(branchToSave.getAddressCity());

        RentalResponseForBranch rentalResponseForBranch = new RentalResponseForBranch();
        rentalResponseForBranch.setId(branchToSave.getRental().getId());

        branchResponse.setRentalResponseForBranch(rentalResponseForBranch);

        return branchResponse;
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
}

