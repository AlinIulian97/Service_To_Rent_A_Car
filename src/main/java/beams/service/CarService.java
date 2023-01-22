package beams.service;


import beams.entity.Branch;
import beams.entity.Car;
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
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    private final BranchRepository branchRepository;

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
}


