package DAL;

import BE.Guest;
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
     * @param email of the user
     * @param isAdmin
     * @return
     * @throws SQLException
     */
    public void createUser(String username, String password, String email, boolean isAdmin) throws SQLException {
        try (Connection conn = connection.getConnection()){
            String sql = "INSERT INTO Users(Username, Password, Email, IsAdmin) values (?,?,?,?);";

            try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                preparedStatement.setBoolean(4, isAdmin);
                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.getNextException();
            }
        }
    }

    /**
     * takes every parameter of an already existing user object and then sets the new values into an updated user
     * @param user returns the value of the updated user
     */
    public void updateUser(User user){
        try(Connection conn = connection.getConnection()){
            String sql = "UPDATE Users SET Username=?, Password=?, IsAdmin=? WHERE ID=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.getIsAdmin());
            preparedStatement.setInt(4, user.getId());
            if(preparedStatement.executeUpdate() != 1){
                throw new Exception("Could not update User");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * checks what the ID of a specific User and then first deletes the users tickets and then the specific user
     * @param userID of the object that is to be deleted
     */
    public void deleteUser(int userID){
        try(Connection conn = connection.getConnection()){
            String sql1 = "DELETE FROM Users WHERE ID =?;";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setInt(1, userID);
            preparedStatement1.execute();
            
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
