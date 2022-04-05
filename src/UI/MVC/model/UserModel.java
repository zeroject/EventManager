package UI.MVC.model;

import BLL.UserManager;
import DAL.UserDAO;

import java.io.IOException;
import java.sql.SQLException;

public class UserModel {

    private UserManager userManager;

    public UserModel() throws IOException {
        userManager = new UserManager();
    }

    public void createUser(String username, String password, String email, boolean isAdmin) throws SQLException {
        userManager.createUser(username, password, email, isAdmin);
    }

    public void deleteUser(int userID){
        userManager.deleteUser(userID);
    }
}
