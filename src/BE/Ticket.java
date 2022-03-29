package BE;

public class Ticket {

    private int id;
    private int adultAmount;
    private int childAmount;

    public Ticket(int id, int adultAmount, int childAmount){
        this.id = id;
        this.adultAmount = adultAmount;
        this.childAmount = childAmount;
    }

    public int getId() {
        return id;
    }

    public int getAdultAmount() {
        return adultAmount;
    }

    public void setAdultAmount(int adultAmount) {
        this.adultAmount = adultAmount;
    }

    public int getChildAmount() {
        return childAmount;
    }

    public void setChildAmount(int childAmount) {
        this.childAmount = childAmount;
    }
}
