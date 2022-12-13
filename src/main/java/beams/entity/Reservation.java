package beams.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.util.Date;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_of_reservation")
    @Future
    private Date dateOfReservation;

    @Column(name="date_from")
    private Date dateFrom;

    @Column(name="date_to")
    private Date dateTo;

    @Column
    private double amount;

    @OneToOne(mappedBy = "reservation" ,
            cascade = CascadeType.ALL)
    private Refund refund;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="car_id" , referencedColumnName = "id")
    private Car car;

    @ManyToOne(fetch =FetchType.LAZY )
    @JoinColumn(name ="customer_id", referencedColumnName = "id")
    private Customer customer;


}
