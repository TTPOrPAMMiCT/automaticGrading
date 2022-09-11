package TTPOrPAMMiCT.su.service;

import java.util.List;

public interface DaoService<T> {
    void saveEntity(T t);
    List<T> getEntityList();
    List<T> getEntityListById(int id);
    void deleteEntity(T t);
}
