package UI.MVC.controller;
import BE.Event;
import UI.MVC.model.EventModel;
import UI.MVC.model.GuestTicketModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateGuestController implements Initializable
{
    public TextField tfFornavn;
    public TextField tfEfternavn;
    public TextField tfEmail;
    public TextField tfMobilNummer;
    public TextField tfVoksen;
    public TextField tfChild;
    public ComboBox<Event> eventBox;
    private EventModel eventModel;

    

    private GuestTicketModel guestTicketModel;

    public CreateGuestController() throws IOException
    {
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
