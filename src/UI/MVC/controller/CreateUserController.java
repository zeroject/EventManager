package UI.MVC.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.awt.*;

public class CreateUserController {

    public TextField userFirstNameField;
    public TextField userLastNameField;
    public TextField userMobilNumberField;
    public TextField userEmailField;
    public CheckBox isAdminCheck;
    public CheckBox isEventCordinatorCheck;

    public CreateUserController(){
        userFirstNameField = new TextField();
        userLastNameField = new TextField();
    }
}
