package BLL;

import BE.Guest;
import DAL.GuestDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GuestManager {

    private GuestDAO guestDAO;

    public GuestManager() throws IOException {
        guestDAO = new GuestDAO();
    }

    public List<Guest> getAllGuestsInEvent(int eventID) {
        return guestDAO.getAllGuestsInEvent(eventID);
    }

    public void createGuest(String firstName, String lastName, int mNumber, String email) throws SQLException {
        guestDAO.createGuest(firstName, lastName, mNumber, email);
    }

    public void deleteGuest(int guestID){
        guestDAO.deleteGuest(guestID);
    }
}
