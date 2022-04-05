package UI.MVC.controller;


import BE.Event;
import UI.MVC.model.EventModel;
import UI.MVC.model.ParseModel;
import UI.Utility.CREATESCENE;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventInfoController implements Initializable {
    @FXML
    private TableView<Event> tvGuestList;
    @FXML
    private TableColumn<Event, String> tcGuestFName;
    @FXML
    private TableColumn<Event, String> tcGuestLName;
    @FXML
    private TableColumn<Event, String> tcGuestEmail;
    @FXML
    private TableColumn<Event, Integer> tcGuestMNumber;
    @FXML
    private TableColumn<Event, Integer> tcNumberOfTicket;
    @FXML
    private TextArea taInfoBox;
    @FXML
    private TextField txtSearchField;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnEditInfo;
    @FXML
    private Button but;

    private CREATESCENE CREATESCENE = new CREATESCENE();
    private EventModel eventModel;
    private Event event;

    public EventInfoController() throws IOException {
        event = ParseModel.event;
        eventModel = new EventModel();
        taInfoBox = new TextArea(event.getEventInfo());
        txtSearchField = new TextField();
        btnSearch = new Button();
        btnEditInfo = new Button();
        tvGuestList = new TableView<>();
        tcGuestEmail = new TableColumn<>();
        tcGuestFName = new TableColumn<>();
        tcGuestLName = new TableColumn<>();
        tcGuestMNumber = new TableColumn<>();
        tcNumberOfTicket = new TableColumn<>();
    }
    @FXML
    public void users(){
        CREATESCENE.createScene("../view/ManageUsers.fxml", "file:../CSS-Files/main.css", false, this);
        Stage stage = (Stage) but.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void home(){
        CREATESCENE.createScene("../view/HomePage.fxml", "file:../CSS-Files/main.css", false, this);
        Stage stage = (Stage) but.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try
        {
            tvGuestList.setItems(eventModel.getAllEvents());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

