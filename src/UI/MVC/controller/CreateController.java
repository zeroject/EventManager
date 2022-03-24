package UI.MVC.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.time.Clock;
import java.util.ResourceBundle;

public class CreateController implements Initializable
{
    @FXML
    private DatePicker eventDayField;
    @FXML
    private TextField eventNameField;
    @FXML
    private TextArea eventInfoField;
    @FXML
    private TextField eventLocationField;
    @FXML
    private TextField eventTimeField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventNameField = new TextField();
        eventInfoField = new TextArea();
        eventTimeField = new TextField();
        eventLocationField = new TextField();
        eventDayField = new DatePicker();
    }

    public CreateController(){
        eventNameField = new TextField();
        eventInfoField = new TextArea();
        eventTimeField = new TextField();
        eventLocationField = new TextField();
        eventDayField = new DatePicker();
        eventNameField.setPromptText("example: Music Festival");
        eventInfoField.setPromptText("example: Here is where all music lovers are welcome, it will be a 2 hours straight fun with the best bands in the world like....");
        eventTimeField.setPromptText("example: 12:00 ; 14:00");
        eventLocationField.setPromptText("example: CityName, Postnummer, Vej");
    }
    @FXML
    public void createEventHandler(){

    }

}
