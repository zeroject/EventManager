package UI.MVC.controller;

import BE.Event;
import BE.GuestTicket;
import UI.MVC.model.GuestTicketModel;
import UI.MVC.model.ParseModel;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.SnapshotResult;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.PixelBuffer;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.security.auth.callback.Callback;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.util.ResourceBundle;

public class TicketTemplateController implements Initializable {

    @FXML
    private Label eventName;
    @FXML
    private Label eventDate;
    @FXML
    private Label eventLocation;
    @FXML
    private TextArea infoText;
    @FXML
    private Label adultNum;
    @FXML
    private Label childNum;
    @FXML
    private Label ticketID;

    private final GuestTicketModel guestTicketModel;
    private int guestNumber = 0;

    public TicketTemplateController() throws IOException {
        eventName = new Label();
        eventDate = new Label();
        eventLocation = new Label();
        infoText = new TextArea();
        adultNum = new Label();
        childNum = new Label();
        ticketID = new Label();
        guestTicketModel = new GuestTicketModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Event event = ParseModel.event;
        ObservableList<GuestTicket> guests = guestTicketModel.getAllGuestsInEvent(event.getId());
        guestNumber = 0;

        for (GuestTicket guest : guests){

            Platform.runLater(() -> {
                try {
                    eventName.setText(event.getEventName());
                    eventDate.setText(event.getEventDate() + " " + event.getStartTime() + " - " + event.getEndTime());
                    eventLocation.setText(event.getEventLocation());
                    infoText.setText(event.getEventInfo());
                    adultNum.setText("Voksne: " + guest.getAdultAmount());
                    childNum.setText( "Børn: " + guest.getChildAmount());
                    ticketID.setText("ID: " + guest.getId());
                    guestNumber++;

                    getSnapshot();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    public void getSnapshot() throws IOException {
        WritableImage snapshot = ticketID.getScene().snapshot(null);
        BufferedImage pngImage = SwingFXUtils.fromFXImage(snapshot, null);

        File file = new File("src/UI/Pics/tickets/ticket" + guestNumber + ".png");
        try {
            ImageIO.write(pngImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
