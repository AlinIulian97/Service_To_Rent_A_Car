package beams.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @Column
    private Car car;

    @Column(name="date_from")
    private Date dateFrom;

    @Column(name="date_to")
    private Date dateTo;

}
