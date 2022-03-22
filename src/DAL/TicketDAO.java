package DAL;

import BE.Ticket;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    private DatabaseConnector connection;

    public TicketDAO() throws IOException {
        connection = new DatabaseConnector();
    }

    public List<Ticket> getAllTickets() {
        ArrayList<Ticket> tickets = new ArrayList<>();

        try(Connection conn = connection.getConnection()){
            String sql = "SELECT * FROM Tickets;";

            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                ResultSet rs = preparedStatement.getGeneratedKeys();
                while (rs.next()){
                    int id = preparedStatement.getResultSet().getInt("ID");
                    String bImage = preparedStatement.getResultSet().getString("BImage");
                    String ticketType = preparedStatement.getResultSet().getString("TicketType");
                    preparedStatement.executeUpdate();

                    Ticket ticket = new Ticket(id, bImage, ticketType);
                    tickets.add(ticket);
                }
            }

        }catch (SQLException throwable){
            throwable.getNextException();
        }
        return tickets;
    }

    public void addUserToEvent(int userID, int eventID, String bImage, String ticketType)
    {
        String sql = "INSERT INTO Tickets(UserID, EventID, BImage, TicketType) VALUES (?, ?, ?, ?)";
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
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
