package BLL;

import BE.User;
import DAL.UserDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserManager {

    private UserDAO userDAO;

    public UserManager() throws IOException {
        userDAO = new UserDAO();
    }

    /**
     * metode til at få en liste af managers
     * @return liste af managers
     */
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    /**
     * metode til at lave en bruger
     * @param username managers username
     * @param password managers password
     * @param email managers email
     * @throws SQLException
     */
    public void createUser(String username, String password, String email) throws SQLException {
        userDAO.createUser(username, password, email);
    }

    /**
     * metode til at opdatere en bruger
     * @param user opjekt der indeholder ny parametre
     */
    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    /**
     * metode til at slette en bruger
     * @param userID id til den bruger det skal slettes
     */
    public void deleteUser(int userID){
        userDAO.deleteUser(userID);
    }
}
