package UI.MVC.model;

import BLL.TicketManager;
import java.io.IOException;

public class TicketModel {

    private TicketManager ticketManager;

    public TicketModel() throws IOException {
        ticketManager = new TicketManager();
    }
}
