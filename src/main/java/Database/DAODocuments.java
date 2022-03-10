package Database;

import Models.Documents.Documents;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DAODocuments implements DAOInterface<Documents>
{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP2");
    @Override
    public void save(Documents toSave) {

    }

    @Override
    public Documents findById(int id) {
        return null;
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
