package UI.MVC.controller;

import UI.MVC.model.UserModel;
import UI.Utility.CREATESCENE;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ManageUsersController {

    @FXML
    private TableView tvUsers;
    @FXML
    private TableColumn tcFirstName;
    @FXML
    private TableColumn tcLastName;
    @FXML
    private TableColumn tcMNumber;
    @FXML
    private TableColumn tcEmail;
    @FXML
    private TableColumn tcIsAdmin;
    @FXML
    private TableColumn tcIsManager;
    @FXML
    private TableColumn tcID;
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

    public void initialize(){
        tvUsers.setPlaceholder(new Label("No users found in database"));

        tcFirstName.setCellValueFactory();
        tcLastName.setCellValueFactory();
        tcMNumber.setCellValueFactory();
        tcEmail.setCellValueFactory();
        tcIsAdmin.setCellValueFactory();
        tcIsManager.setCellValueFactory();
        tcID.setCellValueFactory();

        tvUsers.setItems(UserModel.getAllManagers());
    }
}
