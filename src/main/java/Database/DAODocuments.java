package Database;

import Models.Documents.Documents;
import Models.Users.Employe;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.print.Doc;
import java.util.List;

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
    public List<Documents> findAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Documents toDelete) {

    }
}
