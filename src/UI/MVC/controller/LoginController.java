package UI.MVC.controller;

import UI.Utility.CREATESCENE;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
    private CREATESCENE CREATESCENE;

    @FXML
    private Button but;

    public LoginController(){
        CREATESCENE = new CREATESCENE();
    }

    /**
     * creates our logic scene
     */
    @FXML
    private void login(){
        CREATESCENE.createScene("../view/HomePage.fxml", "file:../CSS-Files/main.css", false, this);
        Stage stage = (Stage) but.getScene().getWindow();
        stage.close();
    }
}
