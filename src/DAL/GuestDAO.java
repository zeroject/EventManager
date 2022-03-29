package DAL;

import BE.Guest;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {

    private DatabaseConnector connection;

    public GuestDAO() throws IOException {
        connection = new DatabaseConnector();
    }

    public List<Guest> getAllGuestsInEvent(int eventID) {
        ArrayList<Guest> guests = new ArrayList<>();
        PreparedStatement query;
        ResultSet rs;

        try (Connection conn = connection.getConnection()) {
            query = conn.prepareStatement("SELECT Guests.* FROM Tickets WHERE EventID = ?;");
            query.setInt(1, eventID);

            rs = query.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String firstName = rs.getString("FName");
                String lastName = rs.getString("LName");
                int mobileNumber = rs.getInt("MNumber");
                String email = rs.getString("EmailAddress");

                Guest guest = new Guest(id, firstName, lastName, mobileNumber, email);
                guests.add(guest);
            }
        }catch (SQLException throwable){
            throwable.getNextException();
        }
        return guests;
    }

    /**
     * Uses the SQL command INSERT INTO to create a new Guest in the database table guests
     * @param firstName of the guest
     * @param lastName of the guest
     * @param mobileNumber of the guest
     * @param email of the guest
     * @return
     * @throws SQLException
     */
    public void createGuest(String firstName, String lastName, int mobileNumber, String email) throws SQLException {
        try (Connection conn = connection.getConnection()){
            String sql = "INSERT INTO Guests(FName, LName, MNumber, EmailAddress) values (?,?,?,?);";

            try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setInt(3, mobileNumber);
                preparedStatement.setString(4, email);
                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.getNextException();
            }
        }
    }



    /**
     * checks what the ID of a specific Guest and then first deletes the guests tickets and then the specific guest
     * @param guestID of the object that is to be deleted
     */
    public void deleteGuest(int guestID){
        try(Connection conn = connection.getConnection()){
            String sql1 = "DELETE FROM Tickets WHERE ID =?;";
            String sql2 = "DELETE FROM Guests WHERE ID =?;";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setInt(1, guestID);
            preparedStatement1.execute();

            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            preparedStatement2.setInt(1, guestID);
            preparedStatement2.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

}
