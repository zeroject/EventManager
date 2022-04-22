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

    /**
     * metode til at få en liste af events fra DAL laget
     * @return liste af events
     */
    public List<Event> getAllEvents(){
        return eventDAO.getAllEvents();
    }

    /**
     * metode til at lave et event med alle den parametre
     * @param eventName
     * @param eventDate
     * @param eventLocation
     * @param eventInfo
     * @param startTime
     * @param endTime
     * @throws SQLException
     */
    public void createEvent(String eventName, String eventDate, String eventLocation, String eventInfo, String startTime, String endTime) throws SQLException {
        eventDAO.createEvent(eventName, eventDate, eventLocation, eventInfo, startTime, endTime);
    }

    /**
     * metode til at opdatere et event
     * @param event nye parametre til at opdatere det gamle event med
     */
    public void updateEvent(Event event){
        eventDAO.updateEvent(event);
    }

    /**
     * metode til at slette event
     * @param eventID id på event der skal slettes
     */
    public void deleteEvent(int eventID){
        eventDAO.deleteEvent(eventID);
    }
}
