package sample.rooms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.StatusScore;

import java.io.IOException;



public class Controller {

    //ROOMS
    @FXML
    private AnchorPane bedRoom;

    //Other text or stuff
    @FXML
    private TextArea textAreaComputer;

    @FXML
    private TextArea scoreText;


    //BUTTONS
    @FXML
    void goToBedRoom(MouseEvent event) throws IOException {
        changeRoom("bedroom.fxml","Bedroom",event);
    }

    @FXML
    void goToComputerRoom(MouseEvent event) throws IOException, InterruptedException {
        changeRoom("computer.fxml","Computer",event);

    }

    @FXML
    void goToKitchenFromBedroom(MouseEvent event) throws IOException {
        changeRoom("kitchen.fxml", "Kitchen", event);
    }

    @FXML
    void goToBedroomFromKitchen(MouseEvent event) throws IOException {
        changeRoom("bedroom.fxml","Bedroom",event);
    }


    @FXML
    void showComputerInfo(MouseEvent event) {
        textAreaComputer.setText("This is the computer!" + "\n" + "You suck");
        StatusScore.changeScore(-5);
        updateScoreText();
        changevisability(textAreaComputer);
    }

    @FXML
    void layInBed(MouseEvent event) {
        StatusScore.changeScore(5);
        updateScoreText();
    }

    @FXML
    void showContent(MouseEvent event) {
        updateScoreText();
    }


    //METHODS
    public void changeRoom(String fxmlFileName, String roomName, MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
        thisStage.setTitle(roomName);
        thisStage.setScene(new Scene(root, 600, 400));
        thisStage.show();
    }

    public void changevisability(Control control){
        control.setVisible(!control.isVisible());
    }

    public void updateScoreText(){
        scoreText.setText("Score: " + StatusScore.getScore());
    }

}
