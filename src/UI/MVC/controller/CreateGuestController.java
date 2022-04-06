package UI.MVC.controller;
import BE.Event;
import UI.MVC.model.EventModel;
import UI.MVC.model.GuestTicketModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateGuestController implements Initializable
{
    private EventModel eventModel;

    @FXML private ComboBox<Event> eventBox;
    @FXML private TextField tfFornavn;
    @FXML private TextField tfEfternavn;
    @FXML private TextField tfEmail;
    @FXML private TextField tfMobilNummer;
    @FXML private TextField tfVoksen;
    @FXML private TextField tfChild;

    private GuestTicketModel guestTicketModel;

    public CreateGuestController() throws IOException
    {
        tfFornavn = new TextField();
        tfEfternavn = new TextField();
        tfEmail = new TextField();
        tfMobilNummer = new TextField();
        tfVoksen = new TextField();
        tfChild = new TextField();
        guestTicketModel = new GuestTicketModel();
        eventModel = new EventModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventBox.setItems(eventModel.getAllEvents());
    }

    @FXML
    public void createGuest() throws SQLException
    {
        guestTicketModel.createGuest(eventBox.getSelectionModel().getSelectedItem().getId(), tfFornavn.getText(), tfEfternavn.getText(), tfMobilNummer.getText(), tfEmail.getText(), Integer.parseInt(tfVoksen.getText()), Integer.parseInt(tfChild.getText()));
    }
}
