package fr.istic.m2.factory;

import fr.istic.m2.dao.DAO;
import fr.istic.m2.dao.UserDAO;
import fr.istic.m2.entities.User;

public class DAOFactory {

    private static UserDAO userDAO;

    public static DAO<User> getUserDAO(){
        if(userDAO == null){
            return userDAO = new UserDAO();
        }
        return userDAO;
    }
}
