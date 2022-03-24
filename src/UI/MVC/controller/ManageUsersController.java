package UI.MVC.controller;

import BLL.UserManager;
import UI.MVC.model.UserModel;
import UI.Utility.CREATESCENE;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageUsersController {
    UserModel userModel = new UserModel();

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

    public ManageUsersController() throws IOException {
    }

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

        tcFirstName.setCellValueFactory(new PropertyValueFactory<UserManager, String>("FName"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<UserManager, String>("LName"));
        tcMNumber.setCellValueFactory(new PropertyValueFactory<UserManager, Integer>("MNumber"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<UserManager, String>("EmailAddress"));
        tcIsAdmin.setCellValueFactory(new PropertyValueFactory<UserManager, Boolean>("IsAdmin"));
        tcIsManager.setCellValueFactory(new PropertyValueFactory<UserManager, Boolean>("IsManager"));
        tcID.setCellValueFactory(new PropertyValueFactory<UserManager, Integer>("ID"));

        tvUsers.setItems(userModel.getAllManagers());
    }
}
