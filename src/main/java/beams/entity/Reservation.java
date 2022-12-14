package beams.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "date_of_reservation")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dateOfReservation;

    @Column(name = "date_from")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dateFrom;

    @Column(name = "date_to")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dateTo;

    @Column
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


    @OneToOne(mappedBy = "reservation",
            cascade = CascadeType.ALL)
    private Refund refund;


}
