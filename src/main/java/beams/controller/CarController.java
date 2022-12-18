package beams.controller;

import beams.model.car.CarRequest;
import beams.model.car.CarResponse;
import beams.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/add")
    public CarResponse addCar(@RequestBody @Valid CarRequest carRequest) {
        return carService.saveCar(carRequest);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCar(@PathVariable Integer id) {
        carService.delete(id);
    }

    @GetMapping("/list")
    public List<CarResponse> getAllCar() {
        listToPrint(carService.getAllCars());
        return carService.getAllCars();
    }

    public void listToPrint(List<CarResponse> list) {
        carService.printCarList(list);
    }

@GetMapping("/get/{id}")
    public CarResponse findById(@PathVariable Integer id) {
       return carService.findById(id);
    }
}

