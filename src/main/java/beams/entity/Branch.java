package beams.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address_city")
    private String addressCity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_rental_id", referencedColumnName = "id")
    private Rental rental;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_work_branch",
            joinColumns =
                    {@JoinColumn(name = "branch_id", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "employee_id", referencedColumnName = "id")})
    private Employee employee;


}
