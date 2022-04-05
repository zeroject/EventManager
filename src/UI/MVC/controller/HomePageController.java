package UI.MVC.controller;

import BE.Event;
import UI.MVC.model.EventModel;
import UI.MVC.model.ParseModel;
import UI.Utility.CREATESCENE;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class HomePageController implements Initializable
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

    public HomePageController() throws IOException
    {
        gridPane = new GridPane();
    }
    @FXML
    public void users(){
        CREATESCENE.createScene("../view/ManageUsers.fxml", "file:../CSS-Files/main.css", false, this);
        Stage stage = (Stage) but.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void create(){
        CREATESCENE.createScene("../view/createEventView.fxml", "file:../CSS-Files/main.css", false, this);;
    }
    @FXML
    public void delete(){
        CREATESCENE.createScene("../view/deleteEventsView.fxml", "file:../CSS-Files/main.css", false, this);
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
            scaleTransitionIN.setToY(0.98);
            scaleTransitionIN.setToX(0.98);
            ScaleTransition scaleTransitionOUT = new ScaleTransition();
            scaleTransitionOUT.setDuration(Duration.millis(100));
            scaleTransitionOUT.setNode(temp);
            scaleTransitionOUT.setToY(1);
            scaleTransitionOUT.setToX(1);
            temp.setOnMouseEntered(e -> scaleTransitionIN.playFromStart());
            temp.setOnMouseExited(e -> scaleTransitionOUT.playFromStart());
            int numButton = i;
            temp.setMinHeight(200);
            temp.setMinWidth(560);
            temp.setPadding(new Insets(-150, 0, 0, 10));
            temp.setAlignment(Pos.BASELINE_LEFT);
            temp.getStyleClass().add("event-buttons");
            temp.setTranslateX(10);
            temp.setId("" + i);
            temp.setFont(font);
            System.out.println(temp);
            temp.setOnAction(e -> eventWindoesCreater(eventModel.getAllEvents().get(i-1)));
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

    private void eventWindoesCreater(Event event){
        ParseModel.event = event;
        CREATESCENE.createScene("../view/EventInfo.fxml", "file:../CSS-Files/main.css", false, this);
        Stage stage = (Stage) but.getScene().getWindow();
        stage.close();
    }
}
