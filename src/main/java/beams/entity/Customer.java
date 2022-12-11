package beams.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String address;

}
