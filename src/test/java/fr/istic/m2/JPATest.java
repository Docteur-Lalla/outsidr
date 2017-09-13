package fr.istic.m2;

import javax.persistence.*;

public class JPATest {
  public static void main(String[] args) {

    EntityManagerFactory factory;

    try{
      factory = Persistence.createEntityManagerFactory("dev");
    }catch(PersistenceException e){
      factory = Persistence.createEntityManagerFactory("devMySQL");
    }

    EntityManager manager = factory.createEntityManager();

    EntityTransaction tx = manager.getTransaction();
    tx.begin();

    try {

    }

    catch(Exception e) {
      e.printStackTrace();
    }

    tx.commit();

    manager.close();
    factory.close();
  }
}
