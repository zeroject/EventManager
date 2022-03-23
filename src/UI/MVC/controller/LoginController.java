package UI.MVC.controller;

import UI.Utility.CREATESCENE;
import javafx.fxml.FXML;

public class LoginController {
    private CREATESCENE CREATESCENE;

    public LoginController(){
        CREATESCENE = new CREATESCENE();
    }
    @FXML
    private void login(){
        CREATESCENE.createScene("../view/HomePage.fxml", "file:UI/CSS-Files/main.css", false, this);
    }
}
