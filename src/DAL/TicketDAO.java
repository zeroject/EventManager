package DAL;

import BE.Ticket;
import java.io.IOException;
import java.sql.*;

public class TicketDAO {

    private DatabaseConnector connection;

    public TicketDAO() throws IOException {
        connection = new DatabaseConnector();
    }

    public void addGuestToEvent(int userID, int eventID, int adultAmount, int childAmount)
    {
        String sql = "INSERT INTO Tickets(UserID, EventID, AdultAmount, ChildAmount) VALUES (?, ?, ?, ?)";
        try (Connection conn = connection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, eventID);
            preparedStatement.setInt(3, adultAmount);
            preparedStatement.setInt(4, childAmount);
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
