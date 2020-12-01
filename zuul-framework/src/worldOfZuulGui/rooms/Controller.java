package worldOfZuulGui.rooms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import worldOfZuulGui.Room;
import java.io.IOException;


public class Controller {

    //Singleton
    StatusScore depressionBar = StatusScore.getInstance();


    //Controls
    @FXML
    private TextArea textAreaComputer;

    @FXML
    private ProgressBar progressBar;


    //Change room methods
    @FXML
    void goNextRoom(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();

        switch (thisStage.getTitle()) {
            case "Bedroom":
                changeRoom(Room.Kitchen.name(), event);
                break;
        }
    }

    @FXML
    void goPrevRoom(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();

        switch (thisStage.getTitle()) {
            case "Kitchen":
            case "Computer":
                changeRoom(Room.Bedroom.name(), event);
                break;
        }
    }


    //Computer room buttons
    @FXML
    void goToComputerRoom(MouseEvent event) throws IOException, InterruptedException {
        changeRoom(Room.Computer.name(), event);
    }

    @FXML
    void showComputerInfo(MouseEvent event) {
        textAreaComputer.setText("This is the computer!" + "\n" + "You suck");
        if(!textAreaComputer.isVisible()){
            depressionBar.changeScore(-0.05);
        }
        updateScoreText();
    }


    //Bedroom items
    @FXML
    void layInBed(MouseEvent event) {
        depressionBar.changeScore(0.05);
        updateScoreText();
    }


    //Initializing the scoreText
    @FXML
    void initialize() {
    progressBar.setProgress(depressionBar.getScore());
    }


    //METHODS
    public void changeRoom(String roomName, MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(roomName +".fxml"));
        thisStage.setTitle(roomName);
        thisStage.setScene(new Scene(root));
        thisStage.show();
    }

    public void updateScoreText(){
        progressBar.setProgress(depressionBar.getScore());
    }

}
