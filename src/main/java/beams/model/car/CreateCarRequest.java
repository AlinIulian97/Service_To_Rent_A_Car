package beams.model.car;

import beams.entity.enums.CarStatusEnum;
import lombok.Data;

@Data
public class CreateCarRequest {

    private CarStatusEnum status;
    private double amount;
    private String bodyType;
    private String carName;
    private String colour;
    private int mileage;
    private String model;
}
