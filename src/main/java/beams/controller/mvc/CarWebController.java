package beams.controller.mvc;

import beams.model.car.CarRequest;
import beams.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CarWebController {
    private final CarService carService;

    @GetMapping("/car")
    public String goToCarPage() {
        return "carPage";
    }

    @GetMapping("/viewCars")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "allCarsPage";
    }

    @PostMapping("/createCar")
    public String createCarPage(@ModelAttribute(value = "createCar")
                                CarRequest request,
                                Model model) {
        CarRequest carRequest = CarRequest.builder()
                .carName(request.getCarName())
                .model(request.getModel())
                .bodyType(request.getBodyType())
                .branchId(request.getBranchId())
                .amount(request.getAmount())
                .mileage(request.getMileage())
                .colour(request.getColour())
                .status(request.getStatus())
                .build();
        carService.saveCar(carRequest);
        model.addAttribute("cars", carService.getAllCars());
        return "allCarsPage";
    }
}
