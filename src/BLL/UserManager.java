package BLL;

import BE.User;
import DAL.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserManager {

    private UserDAO userDAO;

    public UserManager() throws IOException {
        userDAO = new UserDAO();
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    public User createUser(String firstName, String lastName, int mNumber, String email, boolean isManager, boolean isAdmin) throws SQLException {
        return userDAO.createUser(firstName, lastName, mNumber, email, isManager, isAdmin);
    }

    public void deleteUser(User user){
        userDAO.deleteUser(user);
    }
}
