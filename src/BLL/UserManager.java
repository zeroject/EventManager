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

    public void createUser(String username, String password, String email) throws SQLException {
        userDAO.createUser(username, password, email);
    }

    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    public void deleteUser(int userID){
        userDAO.deleteUser(userID);
    }
}
