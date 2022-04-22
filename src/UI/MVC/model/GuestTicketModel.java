package UI.MVC.model;

import BE.GuestTicket;
import BLL.GuestTIcketManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.sql.SQLException;

public class GuestTicketModel {

    private ObservableList<GuestTicket> guestTicketList;
    private GuestTIcketManager guestManager;

    public GuestTicketModel() throws IOException {
        guestTicketList = FXCollections.observableArrayList();
        guestManager = new GuestTIcketManager();
    }

    /**
     * Får en liste med alle Gæster som er i det event med det givet ID
     * @param eventID
     * @return ObservableList med GuestTickets
     */
    public ObservableList<GuestTicket> getAllGuestsInEvent(int eventID) {
        guestTicketList.clear();
        guestTicketList.addAll(guestManager.getAllGuestsInEvent(eventID));
        return guestTicketList;
    }

    /**
     * Funktion som sender parameternes værdier til guestManager
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
        guestManager.createGuest(eventID, firstName, lastName, mNumber, email, adultNum, childNum);
    }

    /**
     * Sender ID vidre til guestManager som skal fjernes
     * @param guestID
     */
    public void deleteGuest(int guestID){
        guestManager.deleteGuest(guestID);
    }
}
