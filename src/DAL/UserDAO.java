package DAL;

import BE.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    private DatabaseConnector connection;

    public UserDAO() throws IOException {
        connection = new DatabaseConnector();
    }

    /**
     * Uses the SQL command INSERT INTO to create a new User in the database table users
     * @param username of the user
     * @param password of the user
     * @param isAdmin
     * @return
     * @throws SQLException
     */
    public void createUser(String username, String password, boolean isAdmin) throws SQLException {
        try (Connection conn = connection.getConnection()){
            String sql = "INSERT INTO Users(Username, Password, IsAdmin) values (?,?,?);";

            try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setBoolean(3, isAdmin);
                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.getNextException();
            }
        }
    }

    /**
     * checks what the ID of a specific User and then first deletes the users tickets and then the specific user
     * @param userID of the object that is to be deleted
     */
    public void deleteUser(int userID){
        try(Connection conn = connection.getConnection()){
            String sql1 = "DELETE FROM Tickets WHERE ID =?;";
            String sql2 = "DELETE FROM Guests WHERE ID =?;";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setInt(1, userID);
            preparedStatement1.execute();

            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            preparedStatement2.setInt(1, userID);
            preparedStatement2.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
