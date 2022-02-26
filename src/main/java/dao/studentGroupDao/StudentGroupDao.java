package dao.studentGroupDao;

import entity.model.StudentGroup;

import java.util.List;

public abstract class StudentGroupDao {
    public abstract List findGroup();
    public abstract StudentGroup findGroupFromId(int id);
    public abstract void deleteGroup(StudentGroup studentGroup);
}
