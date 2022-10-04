package TTPOrPAMMiCT.su.entity.view;

import TTPOrPAMMiCT.su.entity.model.Grade;
import TTPOrPAMMiCT.su.entity.model.Student;
import javafx.scene.control.CheckBox;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class StudentView extends Student {
    private CheckBox delete = new CheckBox("удалить");
    private int finalGrade;
    private double averageGrade;
    private String gradeString;

    public int getFinalGrade() {
        if (getGradeList() != null) {
            List<Grade> gradeList = new ArrayList<>(getGradeList());
            double sumGrade = 0;
            for (int i = 0; i < gradeList.size(); i++) {
                sumGrade += gradeList.get(i).getGrade();
            }
            setFinalGrade((int) Math.round(sumGrade / gradeList.size()));
        }
        return this.finalGrade;
    }

    public double getAverageGrade() {
        if (getGradeList() != null) {
            List<Grade> gradeList = new ArrayList<>(getGradeList());
            double sumGrade = 0;
            for (int i = 0; i < gradeList.size(); i++) {
                sumGrade += gradeList.get(i).getGrade();
            }
            setAverageGrade(sumGrade / gradeList.size());
        }
        return this.averageGrade;
    }

    public String getGradeString() {
        List<Grade> gradeList = new ArrayList<>(getGradeList());
        String convertString = "";
        if (getGradeList() != null) {
            for (int i = 0; i < gradeList.size(); i++) {
                convertString += gradeList.get(i).getGrade() + ",";
            }
            this.gradeString = convertString.replaceAll("[\\[\\]]", "");
        }
        return this.gradeString;
    }
}
