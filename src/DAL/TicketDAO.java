package DAL;

import BE.Ticket;
import BE.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO {

    private DatabaseConnector connection;

    public TicketDAO() throws IOException {
        connection = new DatabaseConnector();
    }

    public Ticket addUserToEvent(int userID, int eventID, String bImage, String ticketType)
    {
        String sql = "INSERT INTO CatMovie(UserID, EventID, BImage, TicketType) VALUES (?, ?, ?, ?)";
        try (Connection conn = connection.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, eventID);
            preparedStatement.setString(2, bImage);
            preparedStatement.setString(2, ticketType);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
            }

            Ticket ticket = new Ticket(id, bImage, ticketType);
            return ticket;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

}
