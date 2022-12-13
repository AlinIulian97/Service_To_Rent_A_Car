package beams.controller;

import beams.entity.Car;
import beams.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping("/add")
    public void addCar (@RequestBody Car car ){
        carService.saveCare(car);
    }
}
