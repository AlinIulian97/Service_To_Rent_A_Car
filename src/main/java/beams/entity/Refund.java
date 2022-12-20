package beams.entity;

import beams.model.employee.EmployeeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.Named;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


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
    @JoinColumn(name = "fk_reservation_id", referencedColumnName = "id" , unique = true)
    private Reservation reservation;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_employee_id" , referencedColumnName = "id")
    private Employee employee;

}
