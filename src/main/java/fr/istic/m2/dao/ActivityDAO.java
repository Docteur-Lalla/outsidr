package fr.istic.m2.dao;

import fr.istic.m2.entities.Activity;

import javax.persistence.Query;
import java.util.List;

public class ActivityDAO extends DAO {

    public ActivityDAO() {
    }

    @Override
    public List<Activity> findAll() {
        return em.createQuery("Select a From Activity a", Activity.class).getResultList();
    }

    @Override
    public Activity findOne(int id) {
        return em.find(Activity.class, id);
    }

    @Override
    public void create(Object obj) {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public void update(Object obj, int id) {
        em.getTransaction().begin();
        Activity act = (Activity) obj;

        Query query = em.createQuery("update Activity set name = :n, location = :l, registration = :r where id = 3");
        query.setParameter("n", act.getName());
        query.setParameter("l", act.getLocation());
        query.setParameter("r", act.getRegistration());
        query.executeUpdate();

        em.getTransaction().commit();
    }

    @Override
    public void delete(Object obj) {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

}
