package beams.mapper;

import beams.entity.Car;
import beams.model.car.CarRequest;
import beams.model.car.CarResponse;
import beams.model.car.CarResponseUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper
public interface CarMapper {

    Car map(CarRequest carRequest);

    @Mapping(target = "branchId", source = "branch.id")
    @Mapping(target = "branchAddressCity", source = "branch.addressCity")
    CarResponse map(Car car);

    List<CarResponse> map(List<Car> allCar);

    CarResponseUpdate mapUpdate(Car car);
}
