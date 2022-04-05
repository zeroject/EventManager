package UI.MVC.model;

import BLL.TicketManager;
import java.io.IOException;

public class TicketModel {

    private TicketManager ticketManager;

    public TicketModel() throws IOException {
        ticketManager = new TicketManager();
    }

    public void addGuestToEvent(int userID, int eventID, int adultAmount, int childAmount){
        ticketManager.addGuestToEvent(userID, eventID, adultAmount, childAmount);
    }
}
