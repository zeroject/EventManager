package UI.MVC.model;

import BLL.EventManager;
import java.io.IOException;
import java.sql.SQLException;

public class EventModel {

    private EventManager eventManager;

    public EventModel() throws IOException {
        eventManager = new EventManager();
    }

    public void getAllEvents(){
        eventManager.getAllEvents();
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
