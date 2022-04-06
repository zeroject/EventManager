package DAL;

import BE.GuestTicket;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestTicketDAO {

    private DatabaseConnector connection;

    public GuestTicketDAO() throws IOException {
        connection = new DatabaseConnector();
    }

    public List<GuestTicket> getAllGuestsInEvent(int eventID) {
        ArrayList<GuestTicket> guestTickets = new ArrayList<>();
        PreparedStatement query;
        ResultSet rs;

        try (Connection conn = connection.getConnection()) {
            query = conn.prepareStatement("SELECT Guests.* FROM Guests WHERE EventID=?;");
            query.setInt(1, eventID);

            rs = query.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String firstName = rs.getString("FName");
                String lastName = rs.getString("LName");
                String mobileNumber = rs.getString("MNumber");
                String email = rs.getString("EmailAddress");
                int  adultNum = rs.getInt("AdultAmount");
                int  childNum = rs.getInt("ChildAmount");

                GuestTicket guestTicket = new GuestTicket(id, firstName, lastName, mobileNumber, email, adultNum, childNum);
                guestTickets.add(guestTicket);
            }
        }catch (SQLException throwable){
            throwable.getNextException();
        }
        return guestTickets;
    }

    /**
     * Uses the SQL command INSERT INTO to create a new GuestTicket in the database table guests
     * @param firstName of the guestTicket
     * @param lastName of the guestTicket
     * @param mobileNumber of the guestTicket
     * @param email of the guestTicket
     * @return
     * @throws SQLException
     */
    public void createGuest(int eventID, String firstName, String lastName, String mobileNumber, String email, int adultNum, int childNum) throws SQLException {
        try (Connection conn = connection.getConnection()){
            String sql = "INSERT INTO Guests(EventID, FName, LName, MNumber, EmailAddress, AdultAmount, ChildAmount) values (?,?,?,?,?,?,?);";

            try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setInt(1, eventID);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
                preparedStatement.setString(4, mobileNumber);
                preparedStatement.setString(5, email);
                preparedStatement.setInt(6, adultNum);
                preparedStatement.setInt(7, childNum);
                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.getNextException();
            }
        }
    }

    /**
     * takes every parameter of an already existing guestTicket object and then sets the new values into an updated guestTicket
     * @param guestTicket returns the value of the updated guestTicket
     */
    public void updateGuest(GuestTicket guestTicket){
        try(Connection conn = connection.getConnection()){
            String sql = "UPDATE Guests SET FName=?, LName=?, MNumber=?, EmailAddress=?, AdultAmount=?, ChildAmount=? WHERE ID=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, guestTicket.getFName());
            preparedStatement.setString(2, guestTicket.getLName());
            preparedStatement.setString(3, guestTicket.getMNumber());
            preparedStatement.setString(4, guestTicket.getEmail());
            preparedStatement.setInt(5, guestTicket.getAdultAmount());
            preparedStatement.setInt(6, guestTicket.getChildAmount());
            preparedStatement.setInt(7, guestTicket.getId());
            if(preparedStatement.executeUpdate() != 1){
                throw new Exception("Could not update GuestTicket");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * checks what the ID of a specific GuestTicket and then first deletes the guests tickets and then the specific guestTicket
     * @param guestID of the object that is to be deleted
     */
    public void deleteGuest(int guestID){
        try(Connection conn = connection.getConnection()){
            String sql1 = "DELETE FROM Guests WHERE ID =?;";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setInt(1, guestID);
            preparedStatement1.execute();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

}
