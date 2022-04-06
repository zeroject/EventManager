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

    public ObservableList<GuestTicket> getAllGuestsInEvent(int eventID) {
        guestTicketList.clear();
        guestTicketList.addAll(guestManager.getAllGuestsInEvent(eventID));
        return guestTicketList;
    }

    public void createGuest(String firstName, String lastName, String mNumber, String email, int adultNum, int childNum) throws SQLException {
        guestManager.createGuest(firstName, lastName, mNumber, email, adultNum, childNum);
    }

    public void deleteGuest(int guestID){
        guestManager.deleteGuest(guestID);
    }
}
