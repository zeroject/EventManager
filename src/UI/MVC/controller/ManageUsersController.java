package UI.MVC.controller;

import BE.Guest;
import BE.User;
import UI.MVC.model.GuestModel;
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
    GuestModel guestModel = new GuestModel();

    @FXML
    private TableView<Guest> tvUsers;
    @FXML
    private TableColumn<Guest, String> tcFirstName;
    @FXML
    private TableColumn<Guest, String> tcLastName;
    @FXML
    private TableColumn<Guest, Integer> tcMNumber;
    @FXML
    private TableColumn<Guest, String> tcEmail;
    @FXML
    private TableColumn<Guest, Integer> tcID;

    private CREATESCENE CREATESCENE = new CREATESCENE();

    @FXML
    private Button but;

    public ManageUsersController() throws IOException {
        tvUsers = new TableView<>();
        tcFirstName = new TableColumn<>();
        tcLastName = new TableColumn<>();
        tcMNumber = new TableColumn<>();
        tcEmail = new TableColumn<>();
        tcID = new TableColumn<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tvUsers.setPlaceholder(new Label("No users found in database"));

        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tcMNumber.setCellValueFactory(new PropertyValueFactory<>("MobileNumber"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tcID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        try
        {
            tvUsers.setItems(guestModel.getAllGuestsInEvent(1));
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
        guestModel.deleteGuest(tvUsers.getSelectionModel().getSelectedItem().getId());
    }

    public void edit(){
        CREATESCENE.createScene("../view/EditView.fxml", "file:../CSS-Files/main.css", false, this);
    }

}
