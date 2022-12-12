package beams.entity;

import beams.entity.enums.CarStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "model")
    private String model;

    @Column(name = "body_type")
    private String bodyType;

    @Column(name = "colour")
    private String colour;

    @Column(name = "mileage")
    private int mileage;

    @Enumerated(EnumType.STRING)
    private CarStatusEnum status;

    @Column(name = "amount")
    private double amount;

}
