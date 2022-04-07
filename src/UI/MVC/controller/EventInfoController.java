package UI.MVC.controller;


import BE.Event;
import BE.GuestTicket;
import UI.MVC.model.EventModel;
import UI.MVC.model.GuestTicketModel;
import UI.MVC.model.ParseModel;
import UI.Utility.CREATESCENE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventInfoController implements Initializable {

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
    private TableColumn<GuestTicket, Integer> tcAdultAmount;
    @FXML
    private TableColumn<GuestTicket, Integer> tcChildrenAmount;
    @FXML
    private TextArea taInfoBox;
    @FXML
    private Button btnEditInfo;
    @FXML
    private PieChart chart;

    GuestTicketModel guestTicketModel = new GuestTicketModel();
    private double voksen = 0;
    private double barn = 0;

    private CREATESCENE CREATESCENE = new CREATESCENE();
    private EventModel eventModel;
    private Event event;
    private GuestTicket guest;

    public EventInfoController() throws IOException {
        event = ParseModel.event;
        guest = ParseModel.guestTicket;
        eventModel = new EventModel();
        taInfoBox = new TextArea(event.getEventInfo());
        chart = new PieChart();
        btnEditInfo = new Button();
        tvGuestList = new TableView<>();
        tcGuestEmail = new TableColumn<>();
        tcGuestFName = new TableColumn<>();
        tcGuestLName = new TableColumn<>();
        tcGuestMNumber = new TableColumn<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tvGuestList.setPlaceholder(new Label("There are no guests added to this event"));

        tcGuestFName.setCellValueFactory(new PropertyValueFactory<>("fName"));
        tcGuestLName.setCellValueFactory(new PropertyValueFactory<>("lName"));
        tcGuestEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tcGuestMNumber.setCellValueFactory(new PropertyValueFactory<>("MNumber"));
        tcAdultAmount.setCellValueFactory(new PropertyValueFactory<>("AdultAmount"));
        tcChildrenAmount.setCellValueFactory(new PropertyValueFactory<>("ChildAmount"));

        try
        {
            tvGuestList.setItems(guestTicketModel.getAllGuestsInEvent(event.getId()));
        } catch (Exception e){
            e.printStackTrace();
        }

        taInfoBox.setText(event.getEventInfo());
        tfDate.setText(event.getEventDate());
        tfLocation.setText(event.getEventLocation());
        tfStart.setText(event.getStartTime());
        tfEnd.setText(event.getEndTime());
        for (int j = 0; j < guestTicketModel.getAllGuestsInEvent(ParseModel.event.getId()).size(); j++) {
            voksen += guestTicketModel.getAllGuestsInEvent(ParseModel.event.getId()).get(j).getAdultAmount();
            barn += guestTicketModel.getAllGuestsInEvent(ParseModel.event.getId()).get(j).getChildAmount();
        }
        System.out.println(voksen);
        System.out.println(barn);
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Voksne antal: " + voksen, voksen),
                        new PieChart.Data("Børn antal: " + barn, barn));
        chart.setTitle("Alders Gruppe");
        chart.setData(pieChartData);
    }

    @FXML
    public void users(){
        CREATESCENE.createScene("../view/ManageUsers.fxml", "file:../CSS-Files/main.css", false, this);
        Stage stage = (Stage) btnEditInfo.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void home(){
        CREATESCENE.createScene("../view/HomePage.fxml", "file:../CSS-Files/main.css", false, this);
        Stage stage = (Stage) btnEditInfo.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void createGuest(){
        CREATESCENE.createScene("../view/createGuestView.fxml", "file:../CSS-Files/main.css", false, this);
    }
    @FXML
    public void removeGuest(){
        guestTicketModel.deleteGuest(tvGuestList.getSelectionModel().getSelectedItem().getId());
    }
    @FXML
    public void createTickets(){
        CREATESCENE.createScene("../view/TicketTemplate.fxml", "file:../CSS-Files/ticket.css", false, this);
    }
}

