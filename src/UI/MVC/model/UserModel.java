package UI.MVC.model;

import BE.User;
import BLL.UserManager;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class UserModel {

    private ObservableList<User> userList;
    private UserManager userManager;

    public UserModel() throws IOException {
        userManager = new UserManager();
    }

    public ObservableList<User> getAllUsers(){
        userList.clear();
        userList.addAll(userManager.getAllUsers());
        return userList;
    }

    public void createUser(String username, String password, String email) throws SQLException {
        userManager.createUser(username, password, email);
    }

    public void updateUser(User user){userManager.updateUser(user);}

    public void deleteUser(int userID){
        userManager.deleteUser(userID);
    }
}
