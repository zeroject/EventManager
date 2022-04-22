package BE;

public class User {

    private int id;
    private String username;
    private String password;
    private String email;

    /**
     * User entitet til at holde på event managers information
     * @param id id på en event manager
     * @param username username på eventmanager
     * @param password password på eventmanager
     * @param email eventamangers email
     */
    public User(int id, String username, String password, String email){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
