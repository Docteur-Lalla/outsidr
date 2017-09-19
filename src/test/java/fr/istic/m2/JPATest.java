package fr.istic.m2;

import fr.istic.m2.dao.DAO;
import fr.istic.m2.factory.DAOFactory;
import fr.istic.m2.entities.Registration;
import fr.istic.m2.entities.User;

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

        test.createUser();
        test.updateUser();
        test.deleteUser();
        test.close();
    }

    private void listUser() {
        List<User> resultList = manager.createQuery("Select a From User a", User.class).getResultList();
        System.out.println("num of users:" + resultList.size());
    }

    private void createUser() {
        DAO<User> user = DAOFactory.getUserDAO();
        user.create(new User("toto", "titi", "tata", new ArrayList<Registration>()));

    }

    private void updateUser() {
        DAO<User> user = DAOFactory.getUserDAO();
        user.update(new User("tot", "titi", "tata", new ArrayList<Registration>()), 3);
    }

    private void deleteUser(){
        DAO<User> user = DAOFactory.getUserDAO();
        try{
            user.delete(user.findOne(12));
        }catch(IllegalArgumentException e){
            System.out.println("L'objet devant être supprimé n'est plus présent dans la base.");
        }
    }

    private void close(){
        DAO<User> user = DAOFactory.getUserDAO();
        user.close();
    }
}
