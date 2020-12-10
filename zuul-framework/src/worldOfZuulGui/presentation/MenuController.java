package worldOfZuulGui.presentation;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import worldOfZuulGui.domain.Room;
import worldOfZuulGui.presentation.Controller;

import java.io.IOException;


public class MenuController extends Controller {
    //FX:ID for Tutorial_5.fxml scene
    @FXML
    private ImageView moveBetweenRoomsTutorial_4;

    @FXML
    private ImageView timeTutorial_2;

    @FXML
    private ImageView timeTutorial;

    @FXML
    private ImageView mentalHealthTutorial;

    @FXML
    private Button moveBetweenRoomsTutorial;

    @FXML
    private Button moveBetweenRoomsTutorial_2;

    @FXML
    private Button hideMoveBetweenRoomsTutorialButton;

    @FXML
    private  Button nextTutorialFXML;

    @FXML
    private Text timeTutorial_3;

    @FXML
    private Text timeTutorial_4;

    @FXML
    private Text moveBetweenRoomsTutorial_3;



    @FXML
    void hideMoveBetweenRoomsTutorial(MouseEvent event){
        mentalHealthTutorial.setVisible(false);
        moveBetweenRoomsTutorial.setVisible(false);
        moveBetweenRoomsTutorial_2.setVisible(false);
        moveBetweenRoomsTutorial_3.setVisible(false);
        moveBetweenRoomsTutorial_4.setVisible(false);
        hideMoveBetweenRoomsTutorialButton.setDisable(true);
        timeTutorial.setVisible(true);
        timeTutorial_2.setVisible(true);
        timeTutorial_3.setVisible(true);
        timeTutorial_4.setVisible(true);
        nextTutorialFXML.setDisable(false);
    }

    @FXML
    void skipTutorial(MouseEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();

        switch (thisStage.getTitle()) {
            case "StartMenu":
            case "gameWon": //Even though the method name is not appropriate for this case it safes us from redoing the same code
            case "gameLost"://Even though the method name is not appropriate for this case it safes us from redoing the same code
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
            case "gameWon": //Even though the method name is not appropriate for this case it safes us from redoing the same code
            case "gameLost"://Even though the method name is not appropriate for this case it safes us from redoing the same code
                changeRoom(Room.StartMenu.name(), event);
                break;
            case "StartMenu":
                changeRoom(Room.Tutorial.name(), event);
                break;
            case "Tutorial":
                changeRoom(Room.Tutorial_2.name(), event);
                break;
            case "Tutorial_2":
                changeRoom(Room.Tutorial_3.name(), event);
                break;
            case "Tutorial_3":
                changeRoom(Room.Tutorial_4.name(), event);
                break;
            case "Tutorial_4":
                changeRoom(Room.Tutorial_5.name(), event);
                break;
            case "Tutorial_5":
                changeRoom(Room.Tutorial_6.name(), event);
                break;
            case "Tutorial_6":
                changeRoom(Room.Bedroom.name(), event);
        }
    }

    @Override
    @FXML
    void initialize() {

    }
}
