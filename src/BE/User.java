package BE;

public class User {

    private int id;
    private String fName;
    private String lName;
    private int mNumber;
    private String email;
    private boolean isManager;
    private boolean isAdmin;

    public User(int id, String fName, String lName, int mNumber, String email, boolean isManager, boolean isAdmin){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.mNumber = mNumber;
        this.email = email;
        this.isManager = isManager;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }

    public int getMobileNumber() {
        return mNumber;
    }

    public void setMobileNumber(int mNumber) {
        this.mNumber = mNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(boolean manager) {
        isManager = manager;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return fName + " " + lName;
    }
}
