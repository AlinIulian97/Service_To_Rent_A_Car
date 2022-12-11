package beams.entity;

import beams.entity.enums.EmployeeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    private EmployeeEnum type;

    @Column(name="first_name")
    private String firstName;

    @Column(name=("last_name"))
    private String lastName;

    @Column(name=("position"))
    private String position;

}
