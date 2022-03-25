package UI.MVC.controller;

import BE.User;
import BLL.UserManager;
import UI.MVC.model.UserModel;
import UI.Utility.CREATESCENE;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageUsersController implements Initializable {
    UserModel userModel = new UserModel();

    @FXML
    private TableView<User> tvUsers;
    @FXML
    private TableColumn<User, String> tcFirstName;
    @FXML
    private TableColumn<User, String> tcLastName;
    @FXML
    private TableColumn<User, Integer> tcMNumber;
    @FXML
    private TableColumn<User, String> tcEmail;
    @FXML
    private TableColumn<User, Boolean> tcIsAdmin;
    @FXML
    private TableColumn<User, Boolean> tcIsManager;
    @FXML
    private TableColumn<User, Integer> tcID;

    private CREATESCENE CREATESCENE = new CREATESCENE();

    @FXML
    private Button but;

    public ManageUsersController() throws IOException {
        tvUsers = new TableView<>();
        tcFirstName = new TableColumn<>();
        tcLastName = new TableColumn<>();
        tcMNumber = new TableColumn<>();
        tcEmail = new TableColumn<>();
        tcIsAdmin = new TableColumn<>();
        tcIsManager = new TableColumn<>();
        tcID = new TableColumn<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tvUsers.setPlaceholder(new Label("No users found in database"));

        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tcMNumber.setCellValueFactory(new PropertyValueFactory<>("MobileNumber"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tcIsAdmin.setCellValueFactory(new PropertyValueFactory<>("IsAdmin"));
        tcIsManager.setCellValueFactory(new PropertyValueFactory<>("IsManager"));
        tcID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        try
        {
            tvUsers.setItems(userModel.getAllManagers());
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void home(){
        CREATESCENE.createScene("../view/HomePage.fxml", "file:../CSS-Files/main.css", false, this);
        Stage stage = (Stage) but.getScene().getWindow();
        stage.close();
    }

    public void create(){
        CREATESCENE.createScene("../view/createUserView.fxml", "file:../CSS-Files/main.css", false, this);
    }
    public void delete(){
        userModel.deleteUser(tvUsers.getSelectionModel().getSelectedItem().getId());
    }

    public void edit(){
        CREATESCENE.createScene("../view/EditView.fxml", "file:../CSS-Files/main.css", false, this);
    }

}
