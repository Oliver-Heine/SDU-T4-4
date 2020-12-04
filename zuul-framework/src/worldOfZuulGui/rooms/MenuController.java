package worldOfZuulGui.rooms;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import worldOfZuulGui.Room;
import worldOfZuulGui.TimeClass;

import java.io.IOException;


public class MenuController extends Controller {

    @FXML
    void skipTutorial(MouseEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();

        switch (thisStage.getTitle()) {
            case "StartMenu":
                changeRoom(Room.Bedroom.name(), event);
                break;
        }
    }

    @FXML
    void startSession(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();

        switch (thisStage.getTitle()) {
            case "StartScreen":
                changeRoom(Room.StartMenu.name(), event);
                break;
            case "StartMenu":
                changeRoom(Room.Tutorial.name(), event);
                break;
            case "Tutorial":
                changeRoom(Room.Bedroom.name(), event);
        }
    }

    @Override
    @FXML
    void initialize() {

    }

/*
    TimeClass time = TimeClass.getInstance();

    @FXML
    void initialize() {
        switchScenes.setCycleCount(Animation.INDEFINITE);
        switchScenes.play();
    }


    Timeline switchScenes = new Timeline(
            new KeyFrame(Duration.seconds(5),
                    new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {

                        }
                    }));*/

}
