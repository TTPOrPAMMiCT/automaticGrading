package TTPOrPAMMiCT.su.entity.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "grade")
    private int grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
