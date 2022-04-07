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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.Buffer;
import java.util.ResourceBundle;

public class TicketTemplateController implements Initializable {

    @FXML
    private Label ticketID;

    public TicketTemplateController(){
        ticketID = new Label();
        getSnapshot();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ticketID.setText("plz work");
    }

    public void getSnapshot(){

    }

    //Place an image on a PDF file using JavaFX
    public BufferedImage picture(Node node) {
        SnapshotParameters param = new SnapshotParameters();
        param.setDepthBuffer(true);
        WritableImage snapshot = node.snapshot(param, null);
        BufferedImage tempImg = SwingFXUtils.fromFXImage(snapshot, null);
        BufferedImage img = null;
        byte[] imageInByte;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(tempImg, "png", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
            InputStream in = new ByteArrayInputStream(imageInByte);
            img = ImageIO.read(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //the final image sent to the PDJpeg
        return img;
    }


}
