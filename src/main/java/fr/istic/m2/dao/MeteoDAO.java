package fr.istic.m2.dao;

import fr.istic.m2.entities.Meteo;

import javax.persistence.Query;
import java.util.List;

public class MeteoDAO extends DAO {

    public MeteoDAO(){}

    @Override
    public List<Meteo> findAll() {
        return em.createQuery("Select a From Meteo a", Meteo.class).getResultList();
    }

    @Override
    public Meteo findOne(int id){
        return em.find(Meteo.class, id);
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
        Meteo meteo = (Meteo) obj;

        Query query = em.createQuery("update Meteo set snowing = :s, temperature = :t, wave = :w, wind = :v where id = 3");
        query.setParameter("s", meteo.isSnowing());
        query.setParameter("t", meteo.getTemperature());
        query.setParameter("w", meteo.getWave());
        query.setParameter("v", meteo.getWind());
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
