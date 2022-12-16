package beams.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "return_date")
    private Date returnDate;

    @Column
    private double surcharge;

    @Column
    private String comments;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_reservation_id", referencedColumnName = "id")
    private Reservation reservation;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_employee_id", referencedColumnName = "id")
    private Employee employee;

}
