package Database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO {
    protected EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP2");
    protected EntityManager entityManager;
    protected EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }


    protected void throwIfNull(Object o){
        if(o == null) throw new IllegalArgumentException();
    }
    protected void throwIfNotNull(Object o){
        if(o != null) throw new IllegalArgumentException();
    }
    protected void beginTransaction(){
        entityManager = getEntityManager();
        entityManager.getTransaction().begin();
    }
    protected void finishTransaction(){
        throwIfNull(entityManager);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManager = null;
    }
}
