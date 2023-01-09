package beams.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column
    private Double surcharge;

    @Column
    private String comments;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_reservation_id", referencedColumnName = "id" , unique = true)
    private Reservation reservation;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_employee_id" , referencedColumnName = "id")
    private Employee employee;

}
