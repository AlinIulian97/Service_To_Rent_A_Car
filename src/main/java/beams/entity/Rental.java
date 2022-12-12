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
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_rental")
    private String nameRental;

    @Column(name = "contact_address")
    private String contactAddress;

    @Column(name = "owner")
    private String owner;

    @Column(name = "logo_type")
    private String logoType;

    @OneToMany(mappedBy = "rental")
    final private List<Branch> branches = new ArrayList<>();


}
