package UI.MVC.controller;

import UI.MVC.model.EventModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreateController implements Initializable
{
    EventModel eventModel = new EventModel();
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
    @FXML
    private TextField eventTimeField1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventNameField.setPromptText("example: Music Festival");
        eventInfoField.setPromptText("example: Here is where all music lovers are welcome, it will be a 2 hours straight fun with the best bands in the world like....");
        eventTimeField.setPromptText("example: 12:00 ; 14:00");
        eventLocationField.setPromptText("example: CityName, Postnummer, Vej");
    }

    public CreateController() throws IOException {
        eventNameField = new TextField();
        eventInfoField = new TextArea();
        eventTimeField = new TextField();
        eventTimeField1 = new TextField();
        eventLocationField = new TextField();
        eventDayField = new DatePicker();
    }
    @FXML
    public void createEventHandler() throws SQLException {
        String eventName = eventNameField.getText();
        String eventDate = eventDayField.getChronology().toString();
        String eventLocation = eventLocationField.getText();
        String eventInfo = eventInfoField.getText();
        String eventStartTime = eventTimeField.getText();
        String eventEndTime = eventTimeField1.getText();
        eventModel.createEvent(eventName,eventDate,eventLocation,eventInfo,eventStartTime,eventEndTime);
    }

}
