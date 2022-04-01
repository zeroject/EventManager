package DAL;

import BE.Event;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    private DatabaseConnector connection;

    public EventDAO() throws IOException {
        connection = new DatabaseConnector();
    }

    public List<Event> getAllEvents() {
        ArrayList<Event> events = new ArrayList<>();

        try(Connection conn = connection.getConnection()){
            String sql = "SELECT * FROM Events;";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("ID");
                String eventName = rs.getString("EventName");
                String eventDate = rs.getString("EventDate");
                String eventLocation = rs.getString("EventLocation");
                String eventInfo = rs.getString("EventInfo");
                String startTime = rs.getString("StartTime");
                String endTime = rs.getString("EndTime");

                Event event = new Event(id, eventName, eventDate, eventLocation, eventInfo, startTime, endTime);
                events.add(event);
            }
        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return events;
    }

    public void createEvent(String eventName, String eventDate, String eventLocation, String eventInfo, String startTime, String endTime) throws SQLException {
        try (Connection conn = connection.getConnection()){
            String sql = "INSERT INTO Events(EventName, EventDate, EventLocation, EventInfo, StartTime, EndTime) values (?,?,?,?,?,?);";

            try(PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, eventName);
                preparedStatement.setString(2, eventDate);
                preparedStatement.setString(3, eventLocation);
                preparedStatement.setString(4, eventInfo);
                preparedStatement.setString(5, startTime);
                preparedStatement.setString(6, endTime);
                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.getNextException();
            }
        }
    }

    /**
     * takes every parameter of an already existing event object and then sets the new values into an updated event
     * @param event returns the value of the updated event
     */
    public void updateEvent(Event event){
        try(Connection conn = connection.getConnection()){
            String sql = "UPDATE Events SET EventName=?, EventDate=?, EventLocation=?, EventInfo=?, StartTime=?, EndTime=? WHERE ID=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setString(2, event.getEventDate());
            preparedStatement.setString(3, event.getEventLocation());
            preparedStatement.setString(4, event.getEventInfo());
            preparedStatement.setString(5, event.getStartTime());
            preparedStatement.setString(6, event.getEndTime());
            preparedStatement.setInt(7, event.getId());
            if(preparedStatement.executeUpdate() != 1){
                throw new Exception("Could not update Event");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(int eventID){
        try(Connection conn = connection.getConnection()){
            String sql1 = "DELETE FROM Tickets WHERE EventID =?;";
            String sql2 = "DELETE FROM Events WHERE EventID =?;";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setInt(1, eventID);
            preparedStatement1.execute();

            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            preparedStatement2.setInt(1, eventID);
            preparedStatement2.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }


}
