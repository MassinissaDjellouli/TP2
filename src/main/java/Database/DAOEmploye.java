package Database;

import Models.Users.Employe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAOEmploye extends DAO implements DAOInterface<Employe> {

    @Override
    public Employe findById(int id) {
        beginTransaction();
        Employe toReturn = entityManager.find(Employe.class,id);
        finishTransaction();
        return toReturn;
    }

    @Override
    public Set<Employe> findAll() {
        beginTransaction();
        TypedQuery<Employe> query = entityManager.createQuery("select e from Employe e",Employe.class );
        Set<Employe> toReturn = new HashSet(query.getResultList());
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



}
