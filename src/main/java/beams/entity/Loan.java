package beams.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class Loan {

    @Id
    private Integer id;

    @Column(name = "date_of_rental")
    private Date dateOfRental;

    private Employee employee;

    private Reservation reservation;

}
