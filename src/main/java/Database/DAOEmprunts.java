package Database;

import Models.Emprunt;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DAOEmprunts extends DAO implements DAOInterface<Emprunt> {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP2");
    @Override
    public void save(Emprunt toSave) {
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
