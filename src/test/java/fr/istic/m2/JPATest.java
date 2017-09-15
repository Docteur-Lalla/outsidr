package fr.istic.m2;

import javax.persistence.EntityManager;
import java.util.ArrayList;
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
            List<Registration> regs = new ArrayList<Registration>();
            manager.persist(new User("toto", "titi", "tata", regs));
            manager.persist(new User("titi", "tata", "toto", regs));
        }
    }

    private void listUser() {
        List<User> resultList = manager.createQuery("Select a From User a", User.class).getResultList();
        System.out.println("num of users:" + resultList.size());
    }

}
