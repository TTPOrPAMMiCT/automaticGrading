package entity.model;

public class Grade {
    int id;
    int grade;
    int idStudent;

    public Grade() {
    }

    public Grade(int id, int grade, int idStudent) {
        this.id = id;
        this.grade = grade;
        this.idStudent = idStudent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public String toString() {
        return "" + grade;
    }
}
