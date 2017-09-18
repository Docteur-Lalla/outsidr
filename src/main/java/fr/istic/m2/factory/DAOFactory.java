package fr.istic.m2.factory;

import fr.istic.m2.dao.*;
import fr.istic.m2.entities.*;

public class DAOFactory {

    private static UserDAO userDAO;
    private static ActivityDAO activityDAO;
    private static LocationDAO locationDAO;
    private static MeteoDAO meteoDAO;
    private static RegistrationDAO registrationDAO;

    public static DAO<User> getUserDAO(){
        if(userDAO == null){
            return userDAO = new UserDAO();
        }
        return userDAO;
    }

    public static DAO<Activity> getActivityDAO(){
        if(activityDAO == null){
            return activityDAO = new ActivityDAO();
        }
        return userDAO;
    }

    public static DAO<Location> getLocatonDAO(){
        if(locationDAO == null){
            return locationDAO = new LocationDAO();
        }
        return activityDAO;
    }

    public static DAO<Meteo> getMeteoDAO(){
        if(meteoDAO == null){
            return meteoDAO = new MeteoDAO();
        }
        return meteoDAO;
    }

    public static DAO<Registration> getRegistrationDAO(){
        if(registrationDAO == null){
            return registrationDAO = new RegistrationDAO();
        }
        return registrationDAO;
    }
}
