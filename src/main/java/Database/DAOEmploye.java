package Database;

import Models.Users.Employe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOEmploye extends DAO implements DAOInterface<Employe> {

    @Override
    public void save(Employe toSave) {
        throwIfNull(toSave);
        beginTransaction();
        entityManager.persist(toSave);
        finishTransaction();
    }

    @Override
    public Employe findById(int id) {
        beginTransaction();
        Employe toReturn = entityManager.find(Employe.class,id);
        finishTransaction();
        return toReturn;
    }

    @Override
    public List<Employe> findAll() {
        beginTransaction();
        TypedQuery<Employe> query = entityManager.createQuery("select e from Employe e",Employe.class );
        List<Employe> toReturn = query.getResultList();
        finishTransaction();
        return toReturn;
    }

    @Override
    public void deleteById(int id) {
        beginTransaction();
        Employe toDelete = findById(id);
        throwIfNull(toDelete);
        entityManager.remove(toDelete);
        finishTransaction();
    }

    @Override
    public void delete(Employe toDelete) {
        beginTransaction();
        throwIfNull(toDelete);
        entityManager.remove(toDelete);
        finishTransaction();
    }


}
