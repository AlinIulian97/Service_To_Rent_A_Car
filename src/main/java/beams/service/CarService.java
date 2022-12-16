package beams.service;


import beams.entity.Car;
import beams.exception.BusinessException;
import beams.mapper.CarMapper;
import beams.model.car.CarRequest;
import beams.model.car.CarResponse;
import beams.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarResponse saveCar(CarRequest carRequest){
        checkDuplicate(carRequest);
        Car car = carMapper.map(carRequest);
        return carMapper.map(carRepository.save(car));
    }

    public void delete(Integer id){
        Car carToDelete =carRepository.findById(id).orElseThrow(
                () -> new BusinessException("Car id not found")
        );
        carRepository.delete(carToDelete);
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

