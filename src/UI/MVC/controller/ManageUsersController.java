package UI.MVC.controller;

import UI.Utility.CREATESCENE;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManageUsersController {

    private CREATESCENE CREATESCENE = new CREATESCENE();

    @FXML
    private Button but;
    @FXML
    public void home(){
        CREATESCENE.createScene("../view/HomePage.fxml", "file:../CSS-Files/main.css", false, this);
        Stage stage = (Stage) but.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void create(){
        CREATESCENE.createScene("../view/createView.fxml", "file:../CSS-Files/main.css", false, this);
    }
    @FXML
    public void edit(){
        CREATESCENE.createScene("../view/EditView.fxml", "file:../CSS-Files/main.css", false, this);
    }
}
