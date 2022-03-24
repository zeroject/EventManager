package UI.MVC.model;

import BE.Event;
import BLL.EventManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.sql.SQLException;

public class EventModel {

    private ObservableList<Event> eventList;
    private EventManager eventManager;

    public EventModel() throws IOException {
        eventList = FXCollections.observableArrayList();
        eventManager = new EventManager();
    }

    public ObservableList<Event> getAllEvents(){
        eventList.clear();
        eventList.addAll(eventManager.getAllEvents());
        return eventList;
    }

    public void createEvent(String eventName, String eventDate, String eventLocation, String eventInfo, String startTime, String endTime) throws SQLException {
        eventManager.createEvent(eventName, eventDate, eventLocation, eventInfo, startTime, endTime);
    }

    public void editEvent(){
        //TODO
    }

    public void deleteEvent(int eventID){
        eventManager.deleteEvent(eventID);
    }

}
