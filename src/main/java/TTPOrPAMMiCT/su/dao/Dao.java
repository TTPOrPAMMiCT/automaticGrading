package TTPOrPAMMiCT.su.dao;

import java.util.ArrayList;

public interface Dao {
    void save();
    ArrayList getEntity();
    /*ArrayList getEntityById(T object);*/
    void delete();
}