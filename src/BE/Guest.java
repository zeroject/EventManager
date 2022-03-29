package BE;

public class Guest {

    int id;
    String fName;
    String lName;
    int mNumber;
    String email;

    public Guest(int id, String fName, String lName, int mNumber, String email){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.mNumber = mNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getmNumber() {
        return mNumber;
    }

    public void setmNumber(int mNumber) {
        this.mNumber = mNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return fName + " " + lName;
    }
}
