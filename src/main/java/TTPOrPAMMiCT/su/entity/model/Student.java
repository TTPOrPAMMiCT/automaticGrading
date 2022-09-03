package TTPOrPAMMiCT.su.entity.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

    @ManyToOne
    @JoinColumn(name = "squad_id")
    private Squad squad;


    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Grade> gradeList;

}
