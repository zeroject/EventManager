package UI.MVC.controller;

import BE.User;
import UI.MVC.model.ParseModel;
import UI.MVC.model.UserModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditController implements Initializable
{
    @FXML TextField tfUsername;
    @FXML TextField tfPassword;
    @FXML TextField tfEmail;

    private User user;
    private UserModel userModel = new UserModel();

    public EditController() throws IOException
    {
        tfUsername = new TextField();
        tfPassword = new TextField();
        tfEmail = new TextField();
        user = ParseModel.user;
    }

    @Override public void initialize(URL location, ResourceBundle resources)
    {
        tfUsername.setPromptText(user.getUsername());
        tfEmail.setPromptText(user.getEmail());
    }

    @FXML
    private void updateUser(){
        User tempUser = new User(user.getId(), tfUsername.getText(), tfPassword.getText(), tfEmail.getText(), true);
        userModel.updateUser(tempUser);
    }

}
