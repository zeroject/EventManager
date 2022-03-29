package UI.MVC.model;

import BE.Guest;
import BLL.GuestManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.sql.SQLException;

public class GuestModel {

    private ObservableList<Guest> guestList;
    private GuestManager guestManager;

    public GuestModel() throws IOException {
        guestList = FXCollections.observableArrayList();
        guestManager = new GuestManager();
    }

    public ObservableList<Guest> getAllGuestsInEvent(int eventID) {
        guestList.clear();
        guestList.addAll(guestManager.getAllGuestsInEvent(eventID));
        return guestList;
    }

    public void createGuest(String firstName, String lastName, int mNumber, String email) throws SQLException {
        guestManager.createGuest(firstName, lastName, mNumber, email);
    }

    public void deleteGuest(int guestID){
        guestManager.deleteGuest(guestID);
    }
}
