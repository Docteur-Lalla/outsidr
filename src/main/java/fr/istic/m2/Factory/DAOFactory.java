package fr.istic.m2.Factory;

import fr.istic.m2.DAO.DAO;
import fr.istic.m2.DAO.UserDAO;
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
