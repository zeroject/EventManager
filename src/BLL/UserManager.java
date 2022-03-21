package BLL;

import BE.User;
import DAL.UserDAO;

import java.io.IOException;

public class UserManager {

    private UserDAO userDAO;

    public UserManager() throws IOException {
        userDAO = new UserDAO();
    }

    public User createUser(String firstName, String lastName, int mNumber, String email, boolean isManager, boolean isAdmin){

        User user = userDAO.createUser(firstName, lastName, mNumber, email, isManager, isAdmin);
        return user;
    }

    public void deleteUser(User user){
        userDAO.deleteUser(user);
    }
}
