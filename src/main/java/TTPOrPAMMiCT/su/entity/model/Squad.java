package TTPOrPAMMiCT.su.entity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "squad")
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "squad", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Student> students;

    @Override
    public String toString() {
        return name;
    }
}
