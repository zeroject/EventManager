package UI.MVC.controller;

import UI.MVC.model.UserModel;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class CreateUserController {
    private UserModel userModel = new UserModel();

    public TextField userFirstNameField;
    public TextField userLastNameField;
    public TextField userEmailField;
    public CheckBox isAdminCheck;

    public CreateUserController() throws IOException {
        userFirstNameField = new TextField();
        userLastNameField = new TextField();
        userEmailField = new TextField();
        isAdminCheck = new CheckBox();
    }

    public void createUser() throws SQLException {
        if (userEmailField.getText() != null){
            String firstName = userFirstNameField.getText();
            String lastName = userLastNameField.getText();
            String email = userEmailField.getText();
            userModel.createUser(firstName, lastName, email, true);
        }
    }
}
