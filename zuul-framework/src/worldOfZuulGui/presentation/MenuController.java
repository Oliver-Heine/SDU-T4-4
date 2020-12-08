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

    //FX:ID for Tutorial_3.fxml scene
    // Show the progressbar in the tutorialSession when the scene is clicked.
    @FXML
    private ImageView mentalHealthTutorial;

    @FXML
    private ImageView mentalHealthTutorial_2;

    @FXML
    private ImageView mentalHealthTutorial_3;

    @FXML
    private ImageView mentalHealthTutorial_4;

    @FXML
    private ImageView moveBetweenRoomsTutorial_4;

    @FXML
    private ImageView timeTutorial;

    @FXML
    private ProgressBar mentalHealthTutorial_5;

    @FXML
    private Text timeTutorial_1;

    @FXML
    private Text playerTutorial_3Text_2;

    @FXML
    private Text moveBetweenRoomsTutorial_3;

    @FXML
    private Button moveBetweenRoomsTutorial;

    @FXML
    private Button moveBetweenRoomsTutorial_2;

    @FXML
    private Button showMentalHealthTutorialButton;

    @FXML
    private Button hideMentalHealthTutorialButton;

    @FXML
    private Button nextTutorialButton;

    @FXML
    private Button showMoveBetweenRoomsTutorial;

    @FXML
    private Button hideMoveBetweenRoomsTutorial;

    @FXML
    private Button showTimeTutorial;

    @FXML
    private Button hideTimeTutorial;

    @FXML
    private Button nextTutorialFXML;

    //Makes the mentalHealthTutorial visible, the showButton unavailable and the next available
    @FXML
    void showMentalHealthTutorial(MouseEvent event){
            mentalHealthTutorial.setVisible(true);
            mentalHealthTutorial_2.setVisible(true);
            mentalHealthTutorial_3.setVisible(true);
            mentalHealthTutorial_4.setVisible(true);
            mentalHealthTutorial_5.setVisible(true);
            showMentalHealthTutorialButton.setDisable(true);
            hideMentalHealthTutorialButton.setDisable(false);

    }

    //Hide the mentalHealthTutorial, makes the next text-note visible and the next button
    @FXML
    void hideMentalHealthTutorial(MouseEvent event){
        mentalHealthTutorial.setVisible(false);
        mentalHealthTutorial_2.setVisible(false);
        mentalHealthTutorial_3.setVisible(false);
        mentalHealthTutorial_4.setVisible(false);
        mentalHealthTutorial_5.setVisible(false);
        playerTutorial_3Text_2.setVisible(true);
        nextTutorialButton.setDisable(false);

    }

    @FXML
    void getNextTutorialSession(MouseEvent event){
        showMentalHealthTutorialButton.setDisable(false);
    }

    @FXML
    void showMoveBetweenRoomsTutorial(MouseEvent event){
        mentalHealthTutorial.setVisible(true);
        moveBetweenRoomsTutorial.setVisible(true);
        moveBetweenRoomsTutorial_2.setVisible(true);
        moveBetweenRoomsTutorial_3.setVisible(true);
        moveBetweenRoomsTutorial_4.setVisible(true);
        showMentalHealthTutorialButton.setDisable(true);
        hideMentalHealthTutorialButton.setDisable(false);
    }

    @FXML
    void hideMoveBetweenRoomsTutorial(MouseEvent event){
        moveBetweenRoomsTutorial.setVisible(false);
        moveBetweenRoomsTutorial_2.setVisible(false);
        moveBetweenRoomsTutorial_3.setVisible(false);
        moveBetweenRoomsTutorial_4.setVisible(false);
    }

    @FXML
    void skipTutorial(MouseEvent event) throws IOException{
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();

        switch (thisStage.getTitle()) {
            case "StartMenu":
            case "gameWon": //Even though the method name is not appropriate it safes us from redoing the same code
            case "gameLost":
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
            case "gameWon": //Even though the method name is not appropriate it safes us from redoing the same code
            case "gameLost":
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
                changeRoom(Room.Bedroom.name(), event);
        }
    }

    @Override
    @FXML
    void initialize() {

    }


}
