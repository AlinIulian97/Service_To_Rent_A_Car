package beams.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String address;

    @OneToMany(cascade = {CascadeType.ALL} ,
            mappedBy = "customer")
    private List<Reservation> customerReservation;

}
