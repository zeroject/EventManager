package DAL;

import BE.Event;
import BE.User;

import java.io.IOException;
import java.sql.*;

public class EventDAO {

    private DatabaseConnector connection;

    public EventDAO() throws IOException {
        connection = new DatabaseConnector();
    }

    public Event createEvent(String eventName, String eventDate, String eventLocation, String eventInfo, String startTime, String endTime) throws SQLException {
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
                ResultSet rs = preparedStatement.getGeneratedKeys();

                int id = 0;
                if(rs.next()){
                    id = rs.getInt(1);
                }

                Event event = new Event(id, eventName, eventDate, eventLocation, eventInfo, startTime, endTime);
                return event;
            } catch (SQLException throwables) {
                throwables.getNextException();
            }
        }
        return null;
    }

    public void deleteEvent(Event event){
        try(Connection conn = connection.getConnection()){
            String sql1 = "DELETE FROM Tickets WHERE EventID =?;";
            String sql2 = "DELETE FROM Events WHERE EventID =?;";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setInt(1, event.getId());
            preparedStatement1.execute();

            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            preparedStatement2.setInt(1, event.getId());
            preparedStatement2.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }


}
