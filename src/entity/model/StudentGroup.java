package entity.model;

public class StudentGroup {
    private int id;
    private String nameGroup;

    public StudentGroup(int id, String nameGroup, int idGroup) {
        this.id = id;
        this.nameGroup = nameGroup;
    }

    public StudentGroup(int id, String nameGroup) {
        this.id = id;
        this.nameGroup = nameGroup;
    }

    public StudentGroup() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    @Override
    public String toString() {
        return nameGroup;
    }
}
