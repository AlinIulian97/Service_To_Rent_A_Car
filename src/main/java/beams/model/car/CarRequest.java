package beams.model.car;

import beams.entity.enums.CarModelEnum;
import beams.entity.enums.CarStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarRequest {

    private Integer id;

    @Enumerated(EnumType.STRING)
    private CarStatusEnum status;

    private Double amount;

    @NotBlank(message = "Invalid body type")
    private String bodyType;

    @NotBlank(message = "Invalid car Name")
    private String carName;

    @NotBlank(message = "Invalid colour")
    private String colour;

    private int mileage;

    @Enumerated(EnumType.STRING)
    private CarModelEnum model;

    private Integer branchId;

}
