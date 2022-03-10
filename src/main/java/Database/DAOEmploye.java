package Database;

import Models.Users.Employe;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DAOEmploye implements DAOInterface<Employe> {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP2");
    @Override
    public void save(Employe toSave) {

    }

    @Override
    public Employe findById(int id) {
        return null;
    }

    @Override
    public List<Employe> findAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Employe toDelete) {

    }
}
