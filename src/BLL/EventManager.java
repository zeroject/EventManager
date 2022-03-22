package BLL;

import BE.Event;
import DAL.EventDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EventManager {

    private EventDAO eventDAO;

    public EventManager() throws IOException {
        eventDAO = new EventDAO();
    }

    public List<Event> getAllEvents(){
        return eventDAO.getAllEvents();
    }

    public void createEvent(String eventName, String eventDate, String eventLocation, String eventInfo, String startTime, String endTime) throws SQLException {
        eventDAO.createEvent(eventName, eventDate, eventLocation, eventInfo, startTime, endTime);
    }

    public void deleteEvent(int eventID){
        eventDAO.deleteEvent(eventID);
    }
}
