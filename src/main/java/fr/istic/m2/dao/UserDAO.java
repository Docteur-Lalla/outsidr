package fr.istic.m2.dao;

import fr.istic.m2.entities.User;

import javax.persistence.Query;
import java.util.List;

public class UserDAO extends DAO {

    public UserDAO() {
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("Select a From User a", User.class).getResultList();
    }

    @Override
    public User findOne(int id){
        return em.find(User.class, id);
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
        User user = (User) obj;

        Query query = em.createQuery("update User set name = :n, password = :p, mail = :m, registration = :r where id = 3");
        query.setParameter("n", user.getName());
        query.setParameter("p", user.getPassword());
        query.setParameter("m", user.getMail());
        query.setParameter("r", user.getRegistration());
        query.executeUpdate();

        em.getTransaction().commit();
    }

    @Override
    public void delete(Object obj) {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void close(){
        emf.close();
    }
}
