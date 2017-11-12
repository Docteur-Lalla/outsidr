package fr.istic.m2;

import fr.istic.m2.entities.Activity;
import fr.istic.m2.entities.Registration;
import fr.istic.m2.entities.User;
import fr.istic.m2.jackson.JacksonParsing;

import javax.persistence.EntityManager;
import java.io.IOException;
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
    }
}
