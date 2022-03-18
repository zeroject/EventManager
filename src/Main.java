import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MVC/view/LoginView.fxml"));
        Parent root = loader.load();
        //root.getStylesheets().add("");
        primaryStage.setTitle("EventManager");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        Application.launch();
    }

}
