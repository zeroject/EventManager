package UI.MVC.controller;
import UI.MVC.model.GuestTicketModel;
import javafx.fxml.FXML;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class CreateGuestController
{
    @FXML TextField tfFornavn;
    @FXML TextField tfEfternavn;
    @FXML TextField tfEmail;
    @FXML TextField tfMobilNummer;
    @FXML TextField tfVoksen;
    @FXML TextField tfChild;

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
    }

    @FXML
    public void createGuest() throws SQLException
    {
        guestTicketModel.createGuest(tfFornavn.getText(), tfEfternavn.getText(), tfMobilNummer.getText(), tfEmail.getText(), Integer.parseInt(tfVoksen.getText()), Integer.parseInt(tfChild.getText()));
    }
}
