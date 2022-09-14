package TTPOrPAMMiCT.su.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "squad")
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "squad", fetch = FetchType.EAGER)
    private List<Student> students;

    @Override
    public String toString() {
        return name;
    }
}
