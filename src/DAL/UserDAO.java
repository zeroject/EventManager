package DAL;

import BE.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private DatabaseConnector connection;

    public UserDAO() throws IOException {
        connection = new DatabaseConnector();
    }

    public List<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();

        try(Connection conn = connection.getConnection()){
            String sql = "SELECT * FROM Users;";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("ID");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String email = rs.getString("Email");

                User user = new User(id, username, password, email);
                users.add(user);
            }
        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return users;
    }

    /**
     * Uses the SQL command INSERT INTO to create a new User in the database table users
     * @param username of the user
     * @param password of the user
     * @param email of the user
     * @return
     * @throws SQLException
     */
    public void createUser(String username, String password, String email) throws SQLException {
        try (Connection conn = connection.getConnection()){
            String sql = "INSERT INTO Users(Username, Password, Email) values (?,?,?,?);";

            try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
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
            String sql = "UPDATE Users SET Username=?, Password=? WHERE ID=?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());
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
