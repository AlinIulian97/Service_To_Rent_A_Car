package beams.mapper;

import beams.entity.Car;
import beams.model.car.CarRequest;
import beams.model.car.CarResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface CarMapper {

    Car map(CarRequest carRequest);

    CarResponse map(Car car);

    List<CarResponse> map(List<Car> allCar);
}
