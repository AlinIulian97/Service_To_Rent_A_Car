package beams.model.car;

import beams.entity.enums.CarStatusEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
public class CarResponse {

    private Integer id;
    private CarStatusEnum status;
    private double amount;
    private String bodyType;
    private String carName;
    private String colour;
    private int mileage;
    private String model;
}
