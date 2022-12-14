package beams.controller;

import beams.model.car.CarRequest;
import beams.model.car.CarResponse;
import beams.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping("/add")
    public CarResponse addCar (@RequestBody @Valid CarRequest carRequest){
        return carService.saveCar(carRequest);

    }
}
