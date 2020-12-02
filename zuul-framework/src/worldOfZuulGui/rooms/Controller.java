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
import worldOfZuulGui.StatusScore;

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
                changeRoom(Room.LivingRoom.name(), event);
                break;
            case "LivingRoom":
                changeRoom(Room.Kitchen.name(), event);
                break;
            case "Kitchen":
                changeRoom(Room.Entry.name(), event);
                break;
        }
    }

    @FXML
    void goPrevRoom(MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();

        switch (thisStage.getTitle()) {
            case "Bedroom":
                changeRoom(Room.BathRoom.name(), event);
                break;
            case "LivingRoom":
            case "BathRoom":
            case "Computer":
                changeRoom(Room.Bedroom.name(), event);
                break;
            case "Kitchen":
                changeRoom(Room.LivingRoom.name(), event);
                break;
            case "Entry":
                changeRoom(Room.Kitchen.name(), event);
                break;
        }
    }


    //Computer room buttons
    @FXML
    void goToComputerRoom(MouseEvent event) throws IOException {
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
        depressionBar.changeScore(-0.05);
        updateScoreText();
    }

    //Bathroom items
    @FXML
    void useToilet(MouseEvent event){
        depressionBar.changeScore(0.05);
        updateScoreText();
    }

    @FXML
    void useBath(MouseEvent event){
        depressionBar.changeScore(0.05);
        updateScoreText();
    }

    @FXML
    void useTV(MouseEvent event){
        depressionBar.changeScore(0.05);
        updateScoreText();
    }

    @FXML
    void readBook(MouseEvent event){
        depressionBar.changeScore(0.05);
        updateScoreText();
    }

    @FXML
    void lookOutWindow(MouseEvent event){
        depressionBar.changeScore(0.05);
        updateScoreText();
    }

    @FXML
    void exitDoor(MouseEvent event){
        depressionBar.changeScore(-0.05);
        updateScoreText();
    }

    //Initializing the scoreText
    @FXML
    void initialize() {
    progressBar.setProgress(depressionBar.getScore());
    }


    //METHODS
    public void changeRoom(String roomName, MouseEvent event) throws IOException, NullPointerException {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage)node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(roomName +".fxml"));
        thisStage.setTitle(roomName);
        thisStage.setScene(new Scene(root));
        thisStage.show();
    }

    public void updateScoreText(){
        progressBar.setProgress(depressionBar.getScore());
    }

}
