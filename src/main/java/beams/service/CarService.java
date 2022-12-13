package beams.service;

import beams.entity.Car;
import beams.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void saveCare(Car car){
        carRepository.save(car);
    }

}
