package beams.model.car;

import beams.entity.enums.CarStatusEnum;
import lombok.Data;

@Data
public class CarResponse {

    private Integer id;
    private CarStatusEnum status;
    private Double amount;
    private String bodyType;
    private String carName;
    private String colour;
    private int mileage;
    private String model;

    private Integer branchId;
    private String branchAddressCity;
}
