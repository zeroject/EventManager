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

    public List<Ticket> getAllTickets(){
        return ticketDAO.getAllTickets();
    }

    public Ticket addUserToEvent(int userID, int eventID, String bImage, String ticketType){
        return ticketDAO.addUserToEvent(userID, eventID, bImage, ticketType);
    }

    public void deleteUserFromEvent(){
        ticketDAO.deleteUserFromEvent();
    }

}
