package UI.MVC.controller;

import UI.Utility.CREATESCENE;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Runnable, Initializable
{

    @FXML
    private Button but;
    @FXML
    private GridPane gridPane;

    private CREATESCENE CREATESCENE = new CREATESCENE();
    private int i = 0;
    private int j = 0;

    Thread t = new Thread();

    public HomePageController(){
        gridPane = new GridPane();
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

    @FXML
    private void addButton()
    {
        if(!(i == 3 && j == 1)){
            Button temp = new Button("Button " + i);
            int numButton = i;
            temp.setMinHeight(200);
            temp.setMinWidth(560);
            temp.setPadding(new Insets(0, 0, 0, 0));
            temp.setTranslateX(10);
            temp.setId("" + i);
            System.out.println(temp);
            temp.setOnAction(e -> System.out.println("id(" + temp.getId() + ") =  " + numButton));
            gridPane.add(temp, j, i);
            i++;
            if(i == 3){
                j++;
                i = 0;
            }
        }
    }

    @Override public void initialize(URL location, ResourceBundle resources)
    {
        addButton();
    }
}
