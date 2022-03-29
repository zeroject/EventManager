package BLL;

import DAL.UserDAO;
import java.io.IOException;
import java.sql.SQLException;

public class UserManager {

    private UserDAO userDAO;

    public UserManager() throws IOException {
        userDAO = new UserDAO();
    }

    public void createUser(String username, String password, boolean isAdmin) throws SQLException {
        userDAO.createUser(username, password, isAdmin);
    }

    public void deleteUser(int userID){
        userDAO.deleteUser(userID);
    }
}
