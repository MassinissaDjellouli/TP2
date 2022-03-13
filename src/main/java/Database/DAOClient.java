package Database;

import Models.Users.Client;
import Models.Users.Employe;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAOClient extends DAO implements DAOInterface<Client> {
    @Override
    public void save(Client toSave) {
        throwIfNull(toSave);
        beginTransaction();
        entityManager.persist(toSave);
        finishTransaction();
    }

    @Override
    public Client findById(int id) {
        beginTransaction();
        Client toReturn = entityManager.find(Client.class,id);
        finishTransaction();
        return toReturn;
    }

    public Client findByIdWEmprunts(int id) {
        beginTransaction();
        TypedQuery<Client> query =
                entityManager.createQuery("select c From Client c left join fetch c.emprunts ce where ce.client.id = :id ",Client.class);
        query.setParameter("id",id);
        Client toReturn = query.getSingleResult();
        finishTransaction();
        return toReturn;
    }

    @Override
    public Set<Client> findAll() {
        beginTransaction();
        TypedQuery<Client> query = entityManager.createQuery("select c from Client c",Client.class );
        Set<Client> toReturn = new HashSet<>(query.getResultList());
        finishTransaction();
        return toReturn;
    }
    public Set<Client> findAllWEmprunts() {
        beginTransaction();
        TypedQuery<Client> query = entityManager.createQuery(
                "select c from Client c left join fetch c.emprunts ce where ce.client.clientNumber = c.clientNumber",Client.class );
        Set<Client> toReturn = new HashSet<>(query.getResultList());
        finishTransaction();
        return toReturn;
    }

    @Override
    public void deleteById(int id) {
        beginTransaction();
        Client toRemove = findById(id);
        throwIfNull(toRemove);
        entityManager.remove(toRemove);
        finishTransaction();
    }

    @Override
    public void delete(Client toDelete) {
        beginTransaction();
        throwIfNull(toDelete);
        entityManager.remove(toDelete);
        finishTransaction();
    }
}
