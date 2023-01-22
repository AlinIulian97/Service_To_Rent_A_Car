package beams.service;

import beams.entity.Branch;
import beams.entity.enums.CarStatusEnum;
import beams.exception.BusinessException;
import beams.mapper.BranchMapper;
import beams.mapper.CarMapper;
import beams.model.branch.BranchDetailsResponse;
import beams.model.branch.BranchRequest;
import beams.model.branch.BranchResponse;
import beams.model.branch.BranchToUpdate;
import beams.model.car.CarResponse;
import beams.repository.BranchRepository;
import beams.repository.EmployeeRepository;
import beams.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;
    private final RentalRepository rentalRepository;

    private final CarService carService;
    private final CarMapper carMapper;


    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

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

    public List<CarResponse> availableCars() {
        List<CarResponse> list = new ArrayList<>();
        for (CarResponse carResponse : carService.getAllCars()) {
            if (carResponse.getStatus() == CarStatusEnum.AVAILABLE) {
                list.add(carResponse);
            }
        }
        if (list.size() == 0) {
            throw new BusinessException("We dont have a available car");
        }
        return list;
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

    public List<CarResponse> carsAvailableAddress(String address) {
        List<CarResponse> list = new ArrayList<>();
        for (CarResponse carResponse : availableCars()) {
            for (BranchResponse branchResponse : availableCarsInBranchSelected(address)) {
                if (Objects.equals(carResponse.getBranchId(), branchResponse.getId())) {
                    list.add(carResponse);
                }
            }
        }
        if(list.isEmpty()){
            throw new BusinessException("Cars in this address is not available, try another Branch");
        }
        return list;
    }
}






