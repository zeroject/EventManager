package UI.MVC.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

public class TicketTemplateController {

    @FXML
    private Label ticketID;

    public TicketTemplateController(){

    }

    public Image getSnapshot(){

        return WritableImage snapshot = ticketID.getScene().snapshot(null);
    }
}
