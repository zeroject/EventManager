package DAL;

import BE.User;
import java.io.IOException;
import java.sql.*;
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
            Statement statement = conn.createStatement();

            if (statement.execute(sql)){
                ResultSet rs = statement.getResultSet();
                while (rs.next()){
                    int id = rs.getInt("ID");
                    String firstName = rs.getString("FName");
                    String lastName = rs.getString("LName");
                    int mNumber = rs.getInt("MNumber");
                    String email = rs.getString("EmailAddress");
                    boolean isAdmin = rs.getBoolean("IsAdmin");
                    boolean isManager = rs.getBoolean("IsManager");

                    User user = new User(id, firstName, lastName, mNumber, email, isManager, isAdmin);
                    users.add(user);
                }
            }

        }catch (SQLException throwable){
            throwable.getNextException();
        }
        return users;
    }

    /**
     * Uses the SQL command INSERT INTO to create a new User in the database table users
     * @param firstName of the user
     * @param lastName of the user
     * @param mobileNumber of the user
     * @param email of the user
     * @param isManager determines if the user is a manager
     * @param isAdmin determines if the user is an admin
     * @return
     * @throws SQLException
     */
    public User createUser(String firstName, String lastName, int mobileNumber, String email, boolean isManager, boolean isAdmin) throws SQLException {
        try (Connection conn = connection.getConnection()){
            String sql = "INSERT INTO Users(FName, LName, MNumber, EmailAddress, IsAdmin, IsManager) values (?,?,?,?,?,?);";

            try(PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setInt(3, mobileNumber);
                preparedStatement.setString(4, email);
                preparedStatement.setBoolean(5, isManager);
                preparedStatement.setBoolean(6, isAdmin);
                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();

                int id = 0;
                if(rs.next()){
                    id = rs.getInt(1);
                }

                User user = new User(id, firstName, lastName, mobileNumber, email, isManager, isAdmin);
                return user;
            } catch (SQLException throwables) {
                throwables.getNextException();
            }
        }
        return null;
    }

    /**
     * checks what the ID of a specific User and then first deletes the users tickets and then the specific user
     * @param user to be deleted
     */
    public void deleteUser(User user){
        try(Connection conn = connection.getConnection()){
            String sql1 = "DELETE FROM Tickets WHERE UserID =?;";
            String sql2 = "DELETE FROM Users WHERE UserID =?;";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement1.setInt(1, user.getId());
            preparedStatement1.execute();

            PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
            preparedStatement2.setInt(1, user.getId());
            preparedStatement2.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

}
