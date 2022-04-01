package UI.MVC.controller;


import UI.Utility.CREATESCENE;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class EventInfoController implements Runnable {
    @FXML
    private TableView tvGuestList;
    @FXML
    private TableColumn tcGuestFName;
    @FXML
    private TableColumn tcGuestLName;
    @FXML
    private TableColumn tcGuestEmail;
    @FXML
    private TableColumn tcGuestMNumber;
    @FXML
    private TableColumn tcNumberOfTicket;
    @FXML
    private TextArea taInfoBox;
    @FXML
    private TextField txtSearchField;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnEditInfo;

    @FXML
    private Button but;

    private CREATESCENE CREATESCENE = new CREATESCENE();

    Thread t = new Thread();

    public EventInfoController(){
        t.start();
    }
    @FXML
    public void users(){
        CREATESCENE.createScene("../view/ManageUsers.fxml", "file:../CSS-Files/main.css", false, this);
        Stage stage = (Stage) but.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void create(){
        CREATESCENE.createScene("../view/createView.fxml", "file:../CSS-Files/main.css", false, this);;
    }
    @FXML
    public void edit(){
        CREATESCENE.createScene("../view/EditView.fxml", "file:../CSS-Files/main.css", false, this);
    }
    private void Update(){

    }

    @Override public void run()
    {

    }
}

