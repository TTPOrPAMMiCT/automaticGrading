package TTPOrPAMMiCT.su.dao;


import org.hibernate.Session;

import java.util.List;

public interface Dao<T> {
    void saveEntity(T t, Session session);
    List<T> getEntityList(Session session);
    List<T> getEntityListById(int id, Session session);
    void deleteEntity(T t, Session session);
}