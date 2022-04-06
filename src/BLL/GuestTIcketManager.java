package BLL;

import BE.GuestTicket;
import DAL.GuestTicketDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GuestTIcketManager {

    private GuestTicketDAO guestTicketDAO;

    public GuestTIcketManager() throws IOException {
        guestTicketDAO = new GuestTicketDAO();
    }

    public List<GuestTicket> getAllGuestsInEvent(int eventID) {
        return guestTicketDAO.getAllGuestsInEvent(eventID);
    }

    public void createGuest(int eventID, String firstName, String lastName, String mNumber, String email, int adultNum, int childNum) throws SQLException {
        guestTicketDAO.createGuest(eventID ,firstName, lastName, mNumber, email, adultNum, childNum);
    }

    public void deleteGuest(int guestID){
        guestTicketDAO.deleteGuest(guestID);
    }
}
