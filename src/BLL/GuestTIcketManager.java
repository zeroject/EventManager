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

    /**
     * metode til at få en liste af gæster
     * @param eventID id på event gæster skal være fra
     * @return liste af gæster
     */
    public List<GuestTicket> getAllGuestsInEvent(int eventID) {
        return guestTicketDAO.getAllGuestsInEvent(eventID);
    }

    /**
     * metode til at lave en gæst i programmet ud fra den parametre
     * @param eventID
     * @param firstName
     * @param lastName
     * @param mNumber
     * @param email
     * @param adultNum
     * @param childNum
     * @throws SQLException
     */
    public void createGuest(int eventID, String firstName, String lastName, String mNumber, String email, int adultNum, int childNum) throws SQLException {
        guestTicketDAO.createGuest(eventID ,firstName, lastName, mNumber, email, adultNum, childNum);
    }

    /**
     * metode til at slette en gæst
     * @param guestID id på gæst der skal slettes
     */
    public void deleteGuest(int guestID){
        guestTicketDAO.deleteGuest(guestID);
    }
}
