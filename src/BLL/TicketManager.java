package BLL;

import BE.Ticket;
import DAL.TicketDAO;
import java.io.IOException;
import java.util.List;

public class TicketManager {

    private TicketDAO ticketDAO;

    public TicketManager() throws IOException {
        ticketDAO = new TicketDAO();
    }

    public void addGuestToEvent(int userID, int eventID, int adultAmount, int childAmount){
        ticketDAO.addGuestToEvent(userID, eventID, adultAmount, childAmount);
    }
}
