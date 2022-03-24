package UI.MVC.model;

import BLL.UserManager;
import java.io.IOException;
import java.sql.SQLException;

public class UserModel {

    private UserManager userManager;

    public UserModel() throws IOException {
        userManager = new UserManager();
    }

    public void getAllUsersInEvent(int eventID) throws SQLException {
        userManager.getAllUsersInEvent(eventID);
    }

    public void createUser(String firstName, String lastName, int mNumber, String email, boolean isManager, boolean isAdmin) throws SQLException {
        userManager.createUser(firstName, lastName, mNumber, email, isManager, isAdmin);
    }

    public void deleteUser(int userID){
        userManager.deleteUser(userID);
    }
}
