package fr.istic.m2.dao;

import fr.istic.m2.entities.Registration;

import javax.persistence.Query;
import java.util.List;

public class RegistrationDAO extends DAO{

    public RegistrationDAO(){}

    @Override
    public List<Registration> findAll() {
        return em.createQuery("Select a From Registration a", Registration.class).getResultList();
    }

    @Override
    public Registration findOne(int id){
        return em.find(Registration.class, id);
    }

    @Override
    public void create(Object obj) {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public void update(Object obj, int id) {}

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
