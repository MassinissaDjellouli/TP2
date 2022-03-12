package Database;

import Models.Emprunt;
import Models.Users.Employe;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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
        beginTransaction();
        Emprunt toReturn = entityManager.find(Emprunt.class,id);
        finishTransaction();
        return toReturn;
    }

    @Override
    public List<Emprunt> findAll() {
        beginTransaction();
        TypedQuery<Emprunt> query = entityManager.createQuery("select e from Emprunt e",Emprunt.class );
        List<Emprunt> toReturn = query.getResultList();
        finishTransaction();
        return toReturn;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Emprunt toDelete) {

    }
}
