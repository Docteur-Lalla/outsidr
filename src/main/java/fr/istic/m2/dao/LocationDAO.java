package fr.istic.m2.dao;

import fr.istic.m2.entities.Location;

import javax.persistence.Query;
import java.util.List;

public class LocationDAO extends DAO{

    public LocationDAO(){}

    @Override
    public List<Location> findAll() {
        return em.createQuery("Select a From Location a", Location.class).getResultList();
    }

    @Override
    public Location findOne(int id){
        return em.find(Location.class, id);
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
        Location loc = (Location) obj;

        Query query = em.createQuery("update Location set name = :n, address = :d, activity = :a, meteo = :m where id = 3");
        query.setParameter("n", loc.getName());
        query.setParameter("d", loc.getAddress());
        query.setParameter("a", loc.getActivity());
        query.setParameter("m", loc.getMeteo());
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
