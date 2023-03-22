package beams.controller;

import beams.model.car.CarResponseForReservation;
import beams.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("statistic")
public class StatisticController {

    public final StatisticService statisticService;

    @GetMapping("/carPopular")
    public double carPopular(){
        return statisticService.popularCarPercentage();
    }

    @GetMapping("/car")
    public CarResponseForReservation car(){
        return statisticService.popularCar();
    }

}
