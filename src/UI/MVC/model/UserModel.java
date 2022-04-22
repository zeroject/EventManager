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

    /**
     * Får en liste af alle users der er i programmet
     * @return ObservableList med Users i
     */
    public ObservableList<User> getAllUsers(){
        userList.clear();
        userList.addAll(userManager.getAllUsers());
        return userList;
    }

    /**
     * Funktion som sender paremeterns værdier vidre til userManager for at lave en ny user
     * @param username
     * @param password
     * @param email
     * @throws SQLException
     */
    public void createUser(String username, String password, String email) throws SQLException {
        userManager.createUser(username, password, email);
    }

    /**
     * Sender en user ned til userManager der skal updateres
     * @param user
     */
    public void updateUser(User user){userManager.updateUser(user);}

    /**
     * Sender et ID ned til userManager som skal fjernes
     * @param userID
     */
    public void deleteUser(int userID){
        userManager.deleteUser(userID);
    }
}
