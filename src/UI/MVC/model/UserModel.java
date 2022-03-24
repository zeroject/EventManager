package UI.MVC.model;

import BE.User;
import BLL.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.sql.SQLException;

public class UserModel {

    private ObservableList<User> userList;
    private UserManager userManager;

    public UserModel() throws IOException {
        userList = FXCollections.observableArrayList();
        userManager = new UserManager();
    }

    public ObservableList<User> getAllManagers() {
        userList.clear();
        userList.addAll(userManager.getAllManagers());
        return userList;
    }

    public ObservableList<User> getAllUsersInEvent(int eventID) {
        userList.clear();
        userList.addAll(userManager.getAllUsersInEvent(eventID));
        return userList;
    }

    public void createUser(String firstName, String lastName, int mNumber, String email, boolean isManager, boolean isAdmin) throws SQLException {
        userManager.createUser(firstName, lastName, mNumber, email, isManager, isAdmin);
    }

    public void deleteUser(int userID){
        userManager.deleteUser(userID);
    }
}
