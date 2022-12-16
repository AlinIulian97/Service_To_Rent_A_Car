package beams.controller;

import beams.model.car.CarRequest;
import beams.model.car.CarResponse;
import beams.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping("/add")
    public CarResponse addCar (@RequestBody @Valid CarRequest carRequest){
        return carService.saveCar(carRequest);
    }

    @DeleteMapping("deleteCar/{id}")
    public void deleteCar(@PathVariable Integer id){
        carService.delete(id);
    }
}
