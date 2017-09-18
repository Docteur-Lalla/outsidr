package fr.istic.m2.DAO;

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

    public User findOne(int id){
        return em.find(User.class, id);
    }

    public void create(Object obj) {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    public void update(Object obj, int id) {
        em.getTransaction().begin();
        User user = (User) obj;

        Query query = em.createQuery("update User set name = :d where id = 3");
        query.setParameter("d", user.getName());
        query.executeUpdate();

        em.getTransaction().commit();
    }

    public void delete(Object obj) {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    public void close(){
        emf.close();
    }
}
