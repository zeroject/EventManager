package UI.MVC.controller;

import UI.MVC.model.EventModel;
import UI.Utility.CREATESCENE;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Runnable, Initializable
{

    @FXML
    private Button but;
    @FXML
    private GridPane gridPane;
    @FXML
    private Label nothingLbl;

    private CREATESCENE CREATESCENE = new CREATESCENE();
    private EventModel eventModel = new EventModel();
    private int i = 0;
    private int j = 0;

    Thread t = new Thread();

    public HomePageController() throws IOException
    {
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
            Button temp = new Button(eventModel.getAllEvents().get(i).getEventName());
            Font font = Font.font("Charcoal", FontWeight.NORMAL, FontPosture.ITALIC, 35);
            ScaleTransition scaleTransitionIN = new ScaleTransition();
            scaleTransitionIN.setDuration(Duration.millis(100));
            scaleTransitionIN.setNode(temp);
            scaleTransitionIN.setByY(0.05);
            scaleTransitionIN.setByX(0.05);
            ScaleTransition scaleTransitionOUT = new ScaleTransition();
            scaleTransitionOUT.setDuration(Duration.millis(100));
            scaleTransitionOUT.setNode(temp);
            scaleTransitionOUT.setByY(-0.05);
            scaleTransitionOUT.setByX(-0.05);
            temp.setOnMouseEntered(e -> scaleTransitionIN.playFromStart());
            temp.setOnMouseExited(e -> scaleTransitionOUT.playFromStart());
            int numButton = i;
            temp.setMinHeight(200);
            temp.setMinWidth(560);
            temp.setPadding(new Insets(-150, 410, 0, 0));
            temp.getStyleClass().add("event-buttons");
            temp.setTranslateX(10);
            temp.setId("" + i);
            temp.setFont(font);
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
        for (int k = 0; k < eventModel.getAllEvents().size(); k++)
        {
            nothingLbl.setOpacity(0);
            but.setOpacity(0);
            but.setDisable(true);
            System.out.println("Works " + k);
            addButton();
        }
    }
}
