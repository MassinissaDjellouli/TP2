package Database;

import java.util.List;

public interface DAOInterface<T> {
    void save(T toSave);
    T findById(int id);
    List<T> findAll();
    void deleteById(int id);
    void delete(T toDelete);
}
