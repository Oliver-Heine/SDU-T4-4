package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class Controller {

    StatusScore statusScore = new StatusScore();

    //ROOMS
    @FXML
    private AnchorPane bedRoom;

    @FXML
    private AnchorPane computerRoom;

    @FXML
    private AnchorPane kitchenRoom;

    @FXML
    private AnchorPane endGameScene;

    //Other text or stuff
    @FXML
    private TextArea textAreaComputer;

    @FXML
    private TextArea scoreText;

    @FXML
    private TextArea endGameText;

    //BUTTONS
    @FXML
    void goToBedRoom(MouseEvent event) {
        changeRoom(computerRoom,bedRoom);
    }

    @FXML
    void goToComputerRoom(MouseEvent event) {
        changeRoom(bedRoom,computerRoom);
    }

    @FXML
    void goToKitchenFromBedroom(MouseEvent event) {
        changeRoom(bedRoom,kitchenRoom);
    }

    @FXML
    void goToBedroomFromKitchen(MouseEvent event) {
        changeRoom(kitchenRoom,bedRoom);
    }

    @FXML
    void showComputerInfo(MouseEvent event) {
        textAreaComputer.setText("This is the computer!" + "\n" + "You suck");
        statusScore.changeScore(-5);
        updateScoreText();
        changevisability(textAreaComputer);
    }

    @FXML
    void layInBed(MouseEvent event) {
        statusScore.changeScore(5);
        updateScoreText();

    }

    @FXML
    void restart(MouseEvent event) {
        statusScore.setScore(50);
        updateScoreText();
        changeRoom(endGameScene,bedRoom);


    }

    //METHODS
    public void changeRoom(AnchorPane fromRoom, AnchorPane toRoom){
        fromRoom.setVisible(false);
        toRoom.setVisible(true);
    }

    public void changevisability(Control control){
        control.setVisible(!control.isVisible());
    }

    public void updateScoreText(){
        if(statusScore.getScore() <= 0){
            endGameScene.setVisible(true);
            endGameText.setText("You Lost!");
        } else if(statusScore.getScore() >= 100){
            endGameScene.setVisible(true);
            endGameText.setText("You Won!");
        }
        scoreText.setText("Score: " + statusScore.getScore());
    }

}
