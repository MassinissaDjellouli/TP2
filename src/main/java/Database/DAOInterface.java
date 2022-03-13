package Database;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public interface DAOInterface<T> {
    T findById(int id);
    Set<T> findAll();
    void deleteById(int id);
}
