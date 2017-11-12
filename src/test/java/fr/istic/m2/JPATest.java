package fr.istic.m2;

import fr.istic.m2.dao.DAO;
import fr.istic.m2.entities.Activity;
import fr.istic.m2.entities.Meteo;
import fr.istic.m2.factory.DAOFactory;
import fr.istic.m2.entities.Registration;
import fr.istic.m2.entities.User;
import fr.istic.m2.jackson.JacksonParsing;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JPATest {

    private EntityManager manager;

    public JPATest(EntityManager manager) {
        this.manager = manager;
    }

    public static void main(String[] args) throws IOException {
        JPATest test = new JPATest(EntityManagerHelper.getEntityManager());

        JacksonParsing jackson = new JacksonParsing();

        //jackson.firstParsing();

        //ObjectMapper map = new ObjectMapper();

        //byte[] json = Files.readAllBytes(Paths.get("C:\\Users\\jmahe\\Desktop\\User.txt"));

        //List<Meteo> me = map.readValue(new URL("http://api.openweathermap.org/data/2.5/box/city?bbox=-4.860856545312458,41.309041165576524,9.674055564062542,51.10892986765849,100000&APPID=cd04d5db91342e48c53e08b7a2fe6b2d"), TypeFactory.defaultInstance().constructCollectionType(List.class, Meteo.class));

        //for (User u : user) {
          //  test.createUser(u);
        //}
        //test.createUser();
        //test.updateUser();
        //test.deleteUser();
        //test.findAllUser();
        //test.finOneUser();
        //test.findOneActivity();
        //test.close();
    }

    private void listUser() {
        List<User> resultList = manager.createQuery("Select a From User a", User.class).getResultList();
        System.out.println("num of users:" + resultList.size());
    }

    private void createUser(User u) {
        DAO<User> user = DAOFactory.getUserDAO();
        user.create(u);

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

    private void findAllUser(){
        DAO<User> user = DAOFactory.getUserDAO();
        List<User> list = user.findAll();

        for (User u : list) {
            System.out.println("FindAll : " + u.getName());
        }
    }

    private void finOneUser(){
        DAO<User> user = DAOFactory.getUserDAO();
        User u = user.findOne(3);

        System.out.println("FindOne : " + u.getName());
    }

    private void findOneActivity(){
        DAO<Activity> act = DAOFactory.getActivityDAO();
        Activity a = act.findOne(1);

        System.out.println("FindOne : " + a.getName());
    }

    private void close(){
        DAO<User> user = DAOFactory.getUserDAO();
        user.close();
    }
}
