package UI.MVC.model;

import BLL.TicketManager;
import java.io.IOException;

public class TicketModel {

    private TicketManager ticketManager;

    public TicketModel() throws IOException {
        ticketManager = new TicketManager();
    }

    public void addUserToEvent(int userID, int eventID, String bImage, String ticketType){
        ticketManager.addUserToEvent(userID, eventID, bImage, ticketType);
    }
}
