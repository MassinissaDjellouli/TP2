package Database;

import Models.Documents.Documents;
import Models.Users.Employe;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.print.Doc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAODocuments extends DAO implements DAOInterface<Documents>
{
    @Override
    public void save(Documents toSave) {
        throwIfNull(toSave);
        beginTransaction();
        entityManager.persist(toSave);
        finishTransaction();
    }

    @Override
    public Documents findById(int id) {
        beginTransaction();
        Documents toReturn = entityManager.find(Documents.class,id);
        finishTransaction();
        return toReturn;
    }

    @Override
    public Set<Documents> findAll() {
        beginTransaction();
        TypedQuery<Documents> query = entityManager.createQuery("select d from Documents d",Documents.class );
        Set<Documents> toReturn = new HashSet(query.getResultList());
        finishTransaction();
        return toReturn;
    }

    @Override
    public void deleteById(int id) {
        beginTransaction();
        Documents toDelete = findById(id);
        throwIfNull(toDelete);
        entityManager.remove(toDelete);
        finishTransaction();
    }

    @Override
    public void delete(Documents toDelete) {
        beginTransaction();
        throwIfNull(toDelete);
        entityManager.remove(toDelete);
        finishTransaction();
    }
}
