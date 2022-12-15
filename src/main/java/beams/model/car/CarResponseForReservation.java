package beams.model.car;

import beams.entity.enums.CarStatusEnum;
import lombok.Data;

@Data
public class CarResponseForReservation {

    private Integer id;
    private CarStatusEnum status;
    private String carName;

}
