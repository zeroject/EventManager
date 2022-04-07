package UI.MVC.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import java.net.URL;
import java.util.ResourceBundle;

public class TicketTemplateController implements Initializable {

    @FXML
    private Label ticketID;

    public TicketTemplateController(){
        ticketID = new Label();
        getSnapshot();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ticketID.setText("plz work");
    }

    public void getSnapshot(){

        WritableImage snapshot = ticketID.getScene().snapshot(null);
        System.out.println(snapshot);
    }


}
