package beams.entity;

import beams.entity.enums.CarStatusEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private CarStatusEnum status;

    @Column(name = "amount", nullable = false)
    @NotNull
    private Double amount;

    @Column(name = "body_type")
    private String bodyType;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "colour")
    private String colour;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "model")
    private String model;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "car")
    private Set<Reservation> reservationList = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_branch_id", referencedColumnName = "id")
    private Branch branch;

}
