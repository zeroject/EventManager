package UI.MVC.controller;

import UI.MVC.model.UserModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class CreateUserController {
    private UserModel userModel = new UserModel();

    public TextField userFirstNameField;
    public TextField userLastNameField;
    public TextField userMobilNumberField;
    public TextField userEmailField;
    public CheckBox isAdminCheck;
    public CheckBox isEventCordinatorCheck;

    public CreateUserController() throws IOException {
        userFirstNameField = new TextField();
        userLastNameField = new TextField();
        userMobilNumberField = new TextField();
        userEmailField = new TextField();
        isAdminCheck = new CheckBox();
        isEventCordinatorCheck = new CheckBox();
    }

    public void createUser() throws SQLException {
        if (userMobilNumberField.getText() != null){
            String firstName = userFirstNameField.getText();
            String lastName = userLastNameField.getText();
            int mobileNumber = Integer.parseInt(userMobilNumberField.getText());
            String email = userEmailField.getText();
            boolean isAdmin = isAdminCheck.isSelected();
            boolean isEventCordinator = isEventCordinatorCheck.isSelected();
            userModel.createUser(firstName, lastName, mobileNumber, email, isAdmin, isEventCordinator);
        }
    }
}
