package beams.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    private Integer id;

    @Column(name = "date_of_reservation")
    private Date dateOfReservation;

    //    @ManyToOne
//    private Customer customer;


    @OneToOne
    @JoinColumn(name="fk_car_id", referencedColumnName = "id")
    private Car car;

    @Column(name="date_from")
    private Date dateFrom;

    @Column(name="date_to")
    private Date dateTo;

}
