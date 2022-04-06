package UI.MVC.controller;


import BE.Event;
import BE.GuestTicket;
import UI.MVC.model.EventModel;
import UI.MVC.model.GuestTicketModel;
import UI.MVC.model.ParseModel;
import UI.Utility.CREATESCENE;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventInfoController implements Initializable {
    @FXML
    private TableColumn<GuestTicket, String> tcAdultAmount;
    @FXML
    private TableColumn<GuestTicket, String> tcChildrenAmount;
    @FXML
    private Button btnCreateGuest;
    @FXML
    private TextField tfEnd;
    @FXML
    private TextField tfStart;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfLocation;
    @FXML
    private TableView<GuestTicket> tvGuestList;
    @FXML
    private TableColumn<GuestTicket, String> tcGuestFName;
    @FXML
    private TableColumn<GuestTicket, String> tcGuestLName;
    @FXML
    private TableColumn<GuestTicket, String> tcGuestEmail;
    @FXML
    private TableColumn<GuestTicket, String> tcGuestMNumber;
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

    GuestTicketModel guestTicketModel = new GuestTicketModel();

    private CREATESCENE CREATESCENE = new CREATESCENE();
    private EventModel eventModel;
    private Event event;
    private GuestTicket guest;

    public EventInfoController() throws IOException {
        event = ParseModel.event;
        guest = ParseModel.guestTicket;
        System.out.println(event);
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

        tvGuestList.setPlaceholder(new Label("There are no guests added to this event"));

        tcGuestFName.setCellValueFactory(new PropertyValueFactory<>("FName"));
        tcGuestLName.setCellValueFactory(new PropertyValueFactory<>("LName"));
        tcGuestEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcGuestMNumber.setCellValueFactory(new PropertyValueFactory<>("MNumber"));
        tcAdultAmount.setCellValueFactory(new PropertyValueFactory<>("adultAmount"));
        tcChildrenAmount.setCellValueFactory(new PropertyValueFactory<>("childAmount"));

        try
        {
            tvGuestList.setItems(guestTicketModel.getAllGuestsInEvent(1));
        } catch (Exception e){
            e.printStackTrace();
        }

        taInfoBox.setText(event.getEventInfo());
        tfDate.setText(event.getEventDate());
        tfLocation.setText(event.getEventLocation());
        tfStart.setText(event.getStartTime());
        tfEnd.setText(event.getEndTime());


    }
}

