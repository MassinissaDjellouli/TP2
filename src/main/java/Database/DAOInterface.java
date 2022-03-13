package Database;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public interface DAOInterface<T> {
    void save(T toSave);
    T findById(int id);
    Set<T> findAll();
    void deleteById(int id);
    void delete(T toDelete);
}
