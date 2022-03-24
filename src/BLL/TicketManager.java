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

    public void addUserToEvent(int userID, int eventID, String bImage, String ticketType){
        ticketDAO.addUserToEvent(userID, eventID, bImage, ticketType);
    }
}
