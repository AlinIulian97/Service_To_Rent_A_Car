package beams.controller;

import beams.entity.Car;
import beams.model.car.CarRequest;
import beams.model.car.CarResponse;
import beams.model.car.CarResponseUpdate;
import beams.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/save")
    public CarResponse addCar(@RequestBody @Valid CarRequest carRequest) {
        return carService.saveCar(carRequest);
    }

    @DeleteMapping("/{id}")
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

    @PatchMapping("/update/{id}")
    public void updateById(@PathVariable Integer id, @RequestBody CarResponseUpdate carResponseUpdate) {
        carService.updateById(id, carResponseUpdate);
    }

    @PatchMapping("/changed/{carId}/{branchId}")
    public void changedBranch(@PathVariable Integer carId , @PathVariable Integer branchId){
       carService.changedBranch(carId , branchId);
    }

    @GetMapping("/carAvailableAddress/{address}")
    public List<CarResponse> CarsAvailableAddress(@PathVariable String address) {
        return carService.carsAvailableAddress(address);
    }

    @GetMapping("/listCarsAvailable")
    public List<CarResponse> carsAvailable() {
        return carService.availableCars();
    }

    @GetMapping("/listCarsStream")
    public List<CarResponse> carsAvailableStream(){
        return carService.availableCarsStreamList();
    }

    @GetMapping("/carAvailableAddress2/{address}")
    public Stream<CarResponse> carResponseStream(@PathVariable  String address){
        return carService.carsAvailableAddress2(address);
    }

}

