package beams.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = {CascadeType.ALL},
    mappedBy = "branch")
    private final List<Employee> employees = new ArrayList<>();

// Un branch o lista

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "branch")
    private final List<Car> cars = new ArrayList<>();



}


