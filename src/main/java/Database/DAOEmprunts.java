package Database;

import Models.Emprunt;
import Models.Users.Employe;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAOEmprunts extends DAO implements DAOInterface<Emprunt> {


    @Override
    public Emprunt findById(int id) {
        beginTransaction();
        Emprunt toReturn = entityManager.find(Emprunt.class,id);
        finishTransaction();
        return toReturn;
    }

    @Override
    public Set<Emprunt> findAll() {
        beginTransaction();
        TypedQuery<Emprunt> query = entityManager.createQuery("select e from Emprunt e",Emprunt.class );
        Set<Emprunt> toReturn = new HashSet(query.getResultList());
        finishTransaction();
        return toReturn;
    }

    @Override
    public void deleteById(int id) {
        beginTransaction();
        Emprunt toRemove = findById(id);
        throwIfNull(toRemove);
        entityManager.remove(toRemove);
        finishTransaction();
    }

}
