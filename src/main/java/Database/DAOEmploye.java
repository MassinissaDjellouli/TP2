package Database;

import Models.Users.Employe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOEmploye implements DAOInterface<Employe> {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP2");
    EntityManager entityManager;
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
        entityManager.remove(findById(id));
        finishTransaction();
    }

    @Override
    public void delete(Employe toDelete) {

    }

    private EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    private void throwIfNull(Object o){
        if(o == null) throw new IllegalArgumentException();
    }
    private void beginTransaction(){
        entityManager = getEntityManager();
        entityManager.getTransaction().begin();
    }
    private void finishTransaction(){
        throwIfNull(entityManager);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManager = null;
    }
}
