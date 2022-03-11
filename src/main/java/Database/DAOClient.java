package Database;

import Models.Users.Client;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DAOClient extends DAO implements DAOInterface<Client> {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP2");
    @Override
    public void save(Client toSave) {

    }

    @Override
    public Client findById(int id) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Client toDelete) {

    }
}
