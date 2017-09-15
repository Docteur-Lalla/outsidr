package fr.istic.m2;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JPATest {

    private EntityManager manager;

    public JPATest(EntityManager manager) {
        this.manager = manager;
    }

    public static void main(String[] args) {
        JPATest test = new JPATest(EntityManagerHelper.getEntityManager());

        EntityManagerHelper.beginTransaction();

        try {
            test.createUser();
        } catch (Exception e) {
            e.printStackTrace();
        }

        test.listUser();

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    private void createUser() {
        int numOfUser = manager.createQuery("Select a From User a", User.class).getResultList().size();
        if (numOfUser == 0) {
            manager.persist(new User("toto", "titi", "tata"));
            manager.persist(new User("titi", "tata", "toto"));
        }
    }

    private void listUser() {
        List<User> resultList = manager.createQuery("Select a From User a", User.class).getResultList();
        System.out.println("num of users:" + resultList.size());
    }

}
