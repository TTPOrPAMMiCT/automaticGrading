package entity.model;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String middleName;
    private int idGroup;

    public Student() {
    }

    public Student(int id,
                   String name,
                   String surname,
                   String middleName,
                   int idGroup) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.idGroup = idGroup;
    }

    public String getStudent() {
        return " id " + this.id +
                " name " + this.name +
                " surName " + this.surname +
                " middle name " + this.middleName +
                " idGroup " + this.idGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", idGroup=" + idGroup +
                '}';
    }
}
