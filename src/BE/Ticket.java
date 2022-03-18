package BE;

public class Ticket {

    private int id;
    private String bImage;
    private String ticketType;

    public Ticket(int id, String bImage, String ticketType){
        this.id = id;
        this.bImage = bImage;
        this.ticketType = ticketType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBackgroundImage() {
        return bImage;
    }

    public void setBackgroundImage(String bImage) {
        this.bImage = bImage;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}
