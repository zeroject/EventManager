package BE;

public class GuestTicket {

    int id;
    String fName;
    String lName;
    String mNumber;
    String email;
    private int adultAmount;
    private int childAmount;

    public GuestTicket(int id, String fName, String lName, String mNumber, String email, int adultAmount, int childAmount){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.mNumber = mNumber;
        this.email = email;
        this.adultAmount = adultAmount;
        this.childAmount = childAmount;
    }

    public int getId() {
        return id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getMNumber() {
        return mNumber;
    }

    public void setMNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return fName + " " + lName;
    }
}
