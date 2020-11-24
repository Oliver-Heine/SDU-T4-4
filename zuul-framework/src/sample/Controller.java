package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Controller {

    @FXML
    private ImageView kitchen;

    @FXML
    private Button computer;

    @FXML
    private Button backButton;

    @FXML
    void printToScreen(MouseEvent event) throws IOException {
        System.out.println("Going to computer");
        kitchen.setImage(new Image("sample/Image/computerRoom.jpg"));
        computer.setVisible(false);
        backButton.setVisible(true);

    }

    @FXML
    void changeRoom(MouseEvent event) {
        System.out.println("living!");
        kitchen.setImage(new Image("sample/Image/bedroom.jpg"));
        computer.setVisible(true);
        backButton.setVisible(false);

    }
}
