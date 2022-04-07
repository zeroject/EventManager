package UI.MVC.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.PixelBuffer;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.util.ResourceBundle;

public class TicketTemplateController implements Initializable {

    @FXML
    private AnchorPane ticket;

    public TicketTemplateController() {
        getSnapshot();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void getSnapshot() {
        WritableImage image = ticket.snapshot(new SnapshotParameters(), null);
        System.out.println("dette er et billede" + image);

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);

        if (file != null){
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
