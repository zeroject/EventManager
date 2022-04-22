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

    /**
     * Funktion som giver en liste med alle events
     * @return arrayList med Events i
     */
    public ObservableList<Event> getAllEvents(){
        eventList.clear();
        eventList.addAll(eventManager.getAllEvents());
        return eventList;
    }

    /**
     *  Funktion som sender parameternes værdier til eventManagerne
     * @param eventName
     * @param eventDate
     * @param eventLocation
     * @param eventInfo
     * @param startTime
     * @param endTime
     * @throws SQLException
     */
    public void createEvent(String eventName, String eventDate, String eventLocation, String eventInfo, String startTime, String endTime) throws SQLException {
        eventManager.createEvent(eventName, eventDate, eventLocation, eventInfo, startTime, endTime);
    }

    /**
     * Sender et event vidre til eventManager
     * @param event
     */
    public void updateEvent(Event event){
        eventManager.updateEvent(event);
    }

    /**
     * Sender et ID ned eventManager som skal slettes
     * @param eventID
     */
    public void deleteEvent(int eventID){
        eventManager.deleteEvent(eventID);
    }

}
