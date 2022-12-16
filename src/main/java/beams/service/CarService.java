package beams.service;


import beams.entity.Car;
import beams.exception.BusinessException;
import beams.mapper.CarMapper;
import beams.model.branch.BranchResponseForeCarResponse;
import beams.model.car.CarRequest;
import beams.model.car.CarResponse;
import beams.repository.BranchRepository;
import beams.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    private final BranchRepository branchRepository;

    public CarResponse saveCar(CarRequest carRequest){
        checkDuplicate(carRequest);
        Car carToSave = carMapper.map(carRequest);

        carToSave.setBranch(branchRepository.findById(carRequest.getBranchId()).orElseThrow(
                ()-> new BusinessException("Branch not found")
        ));

        carRepository.save(carToSave);

        CarResponse carForResponse = new CarResponse();
        carForResponse.setCarName(carToSave.getCarName());
        carForResponse.setId(carToSave.getId());
        carForResponse.setColour(carToSave.getColour());
        carForResponse.setAmount(carToSave.getAmount());
        carForResponse.setMileage(carToSave.getMileage());
        carForResponse.setBodyType(carToSave.getBodyType());
        carForResponse.setModel(carToSave.getModel());
        carForResponse.setStatus(carToSave.getStatus());

        BranchResponseForeCarResponse branchResponseForeCarResponse = new BranchResponseForeCarResponse();
        branchResponseForeCarResponse.setId(carToSave.getBranch().getId());
        branchResponseForeCarResponse.setAddressCity(carToSave.getBranch().getAddressCity());

        carForResponse.setBranchResponseForeCar(branchResponseForeCarResponse);

        return carForResponse;
    }

    public void delete(Integer id){
        Car carToDelete =carRepository.findById(id).orElseThrow(
                () -> new BusinessException("Car id not found")
        );
        carRepository.delete(carToDelete);
    }

    public List<CarResponse> getAllCars (){
        return  carMapper.map(carRepository.findAll());
    }

    public void printCarList(List<CarResponse> listToPrint){
        listToPrint =carMapper.map(carRepository.findAll());
        for(CarResponse carResponse : listToPrint){
            System.out.println(carResponse);
        }
    }

    public void checkDuplicate(CarRequest carRequest) {
        for (Car car : carRepository.findAll()) {
            if (car.getCarName().equals(carRequest.getCarName()) &&
                    car.getModel().equals(carRequest.getModel())) {
                throw new BusinessException("This car exist ");
            }
        }
    }
}

