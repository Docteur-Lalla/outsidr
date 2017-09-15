package fr.istic.m2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class EntityManagerHelper {
  private static final EntityManagerFactory emf;
  private static final ThreadLocal<EntityManager> threadLocal;

  static {
    EntityManagerFactory tempEntityManager;

    try {
      tempEntityManager = Persistence.createEntityManagerFactory("dev");
    } catch (PersistenceException e) {
      tempEntityManager = Persistence.createEntityManagerFactory("devMySQL");
    }

      //tempEntityManager = Persistence.createEntityManagerFactory("mysqlISTIC");

    emf = tempEntityManager;
    threadLocal = new ThreadLocal<EntityManager>();
  }

  public static EntityManager getEntityManager() {
    EntityManager em = threadLocal.get();

    if (em == null) {
      em = emf.createEntityManager();
      threadLocal.set(em);
    }
    return em;
  }

  public static void closeEntityManager() {
    EntityManager em = threadLocal.get();
    if (em != null) {
      em.close();
      threadLocal.set(null);
    }
  }

  public static void closeEntityManagerFactory() {
    emf.close();
  }

  public static void beginTransaction() {
    getEntityManager().getTransaction().begin();
  }

  public static void rollback() {
    getEntityManager().getTransaction().rollback();
  }

  public static void commit() {
    getEntityManager().getTransaction().commit();
  }
}

