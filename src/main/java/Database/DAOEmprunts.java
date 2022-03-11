package Database;

import Models.Emprunt;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DAOEmprunts extends DAO implements DAOInterface<Emprunt> {
    @Override
    public void save(Emprunt toSave) {
        throwIfNull(toSave);
        beginTransaction();
        entityManager.persist(toSave);
        finishTransaction();
    }

    @Override
    public Emprunt findById(int id) {
        return null;
    }

    @Override
    public List<Emprunt> findAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Emprunt toDelete) {

    }
}
