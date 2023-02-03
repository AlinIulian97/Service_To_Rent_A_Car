package beams.service;


import beams.entity.Branch;
import beams.entity.Car;
import beams.entity.enums.CarStatusEnum;
import beams.exception.BusinessException;
import beams.mapper.CarMapper;
import beams.model.branch.BranchResponse;
import beams.model.car.CarRequest;
import beams.model.car.CarResponse;
import beams.model.car.CarResponseUpdate;
import beams.repository.BranchRepository;
import beams.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    private final BranchRepository branchRepository;
    private final BranchService branchService;

    public CarResponse saveCar(CarRequest carRequest) {
        checkDuplicate(carRequest);
        Car carToSave = carMapper.map(carRequest);

        carToSave.setBranch(branchRepository.findById(carRequest.getBranchId()).orElseThrow(
                () -> new BusinessException("Branch not found")
        ));

        carRepository.save(carToSave);

        return carMapper.map(carToSave);
    }

    public void delete(Integer id) {
        Car carToDelete = carRepository.findById(id).orElseThrow(
                () -> new BusinessException("Car id not found")
        );
        carRepository.delete(carToDelete);
    }

    public List<CarResponse> getAllCars() {
        return carMapper.map(carRepository.findAll());
    }

    public void printCarList(List<CarResponse> listToPrint) {
        carMapper.map(carRepository.findAll()).forEach(carResponse -> {
            log.info(String.valueOf(carResponse));
        });
    }

    public CarResponse findById(Integer id) {

        return carMapper.map(carRepository.findById(id).orElseThrow(
                () -> new BusinessException("No car found")));
    }

    public void checkDuplicate(CarRequest carRequest) {
        for (Car car : carRepository.findAll()) {
            if (car.getCarName().equals(carRequest.getCarName()) &&
                    car.getModel().equals(carRequest.getModel())) {
                throw new BusinessException("This car exist ");
            }
        }
    }

    public void updateById(Integer id, CarResponseUpdate carResponseUpdate) {

        Car carToUpdate = carRepository.findById(id).orElseThrow(
                () -> new BusinessException("Car not found")
        );
        carToUpdate.setMileage(carResponseUpdate.getMileage());
    }

    public void changedBranch(Integer id , Integer branchId){
        Car seatChanged = carRepository.findById(id).orElseThrow(
                () -> new BusinessException("Car not found")
        );
        Branch branch = branchRepository.findById(branchId).orElseThrow(()-> new BusinessException("Branch not found"));
        seatChanged.setBranch(branch);
    }

    public List<CarResponse> availableCars() {
        List<CarResponse> list = new ArrayList<>();
        for (CarResponse carResponse : getAllCars()) {
            if (carResponse.getStatus() == CarStatusEnum.AVAILABLE) {
                list.add(carResponse);
            }
        }
        if (list.size() == 0) {
            throw new BusinessException("We don t have a available car");
        }
        return list;
    }

    public List<CarResponse> availableCarsStreamList(){
        return getAllCars()
                .stream()
                .filter(carResponse -> carResponse.getStatus().equals(CarStatusEnum.AVAILABLE))
                .toList();
    }




    public List<CarResponse> carsAvailableAddress(String address) {
        List<CarResponse> list = new ArrayList<>();
        for (CarResponse carResponse : availableCars()) {
            for (BranchResponse branchResponse : branchService.availableCarsInBranchSelected(address)) {
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

    public Stream<CarResponse> carsAvailableAddress2(String address) {
        Map<Integer, BranchResponse> branchesMap = branchService.availableCarsInBranchSelected(address)
                .stream()
                .collect(Collectors
                        .toMap(BranchResponse::getId, b -> b));
        return availableCars()
                .stream()
                .filter(carResponse
                        -> branchesMap
                        .containsKey(carResponse.getBranchId()));
    }
}



