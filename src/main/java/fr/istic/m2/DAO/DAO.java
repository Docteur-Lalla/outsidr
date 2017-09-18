package fr.istic.m2.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class DAO<T> {
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("devMySQL");
    protected EntityManager em = emf.createEntityManager();

    /**
     * Method that allows to find all the object T in the database
     * @return a list of object T
     */
    public abstract List<T> findAll();

    /**
     * Method that allows to find one of the object T in the databe
     * @param id the id of the object T that have to be found
     * @return the object T
     */
    public abstract T findOne(int id);

    /**
     * Method that allows to create a new object T in the database
     * @param obj the object T that have to be created
     */
    public abstract void create(T obj);

    /**
     * Method that allows to update an object T in the database
     * @param obj the object T that have to be updated
     * @param id the id of the object T that have to be updated
     */
    public abstract void update(Object obj , int id);

    /**
     * Method that allows to delete an object T in the database
     * @param obj the object T that have to be deleted
     */
    public abstract void delete(Object obj);

    /**
     * Method that allows to close the EntityManagerFactory
     */
    public abstract void close();
}
