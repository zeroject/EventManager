package UI.MVC.controller;

import BE.Event;
import UI.MVC.model.EventModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteEventsController implements Initializable
{
    private EventModel eventModel;
    @FXML
    private TableView<Event> eventTable;
    @FXML
    private TableColumn<Event, String> tcEventName;

    public DeleteEventsController() throws IOException
    {
        eventTable = new TableView();
        tcEventName  = new TableColumn();
        eventModel = new EventModel();
    }

    @Override public void initialize(URL location, ResourceBundle resources)
    {
        tcEventName.setCellValueFactory(new PropertyValueFactory<>("EventName"));
        try
        {
            eventTable.setItems(eventModel.getAllEvents());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteEvent(){
        if(eventTable.getSelectionModel().getSelectedItem() != null){
            eventModel.deleteEvent(eventTable.getSelectionModel().getSelectedItem().getId());
        }
    }
}
