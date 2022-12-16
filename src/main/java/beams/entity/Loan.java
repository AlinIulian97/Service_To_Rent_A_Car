package beams.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
@Entity
public class Loan {

    @Id
    private Integer id;

    @Column(name = "date_of_rental")
    private Date dateOfRental;

//    @OneToMany
//    @Column(name = "employee_id")
//    private Employee employee;
//
//    @OneToMany
//    @Column(name = "reservation_id")
//    private Reservation reservation;

}
