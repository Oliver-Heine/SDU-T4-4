package worldOfZuulGui.rooms;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import worldOfZuulGui.Item;
import worldOfZuulGui.Room;
import worldOfZuulGui.StatusScore;
import worldOfZuulGui.TimeClass;

import java.awt.event.ActionEvent;
import java.io.IOException;


public class Controller {

    //Singleton
    StatusScore depressionBar = StatusScore.getInstance();
    TimeClass time = TimeClass.getInstance();


    //Controls
    @FXML
    private TextArea textAreaComputer;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label timeLabel;


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

    //Kitchen items:
    Item fridge = new Item("You open the fridge and get some food",0.05);
    Item freezer = new Item("You open the freezer and eat some ice cream!", -0.05);

    //Bedroom items:
    Item bed = new Item("You lay in your bed",0.05);
    Item computer = new Item("You finished a voice chat with your friends, you feel good",0.05);

    //Livingroom items:
    Item tv = new Item("You watch some tv",-0.05);
    Item book = new Item("You read you for a while",0.05);
    Item window = new Item("You stare out the window, sad that you can't go outside",-0.05);

    //Bathroom items:
    Item toilet = new Item("You use the toilet",0.05);
    Item bath = new Item("You take a nice long bath", 0.05);

    //Entrance items:
    Item door = new Item("You look at the door, and wonder what is outside",0.05);
    Item mirror = new Item("You take a deep look in the mirror and feel lonely",-0.05);

    @FXML
    void showComputerInfo(MouseEvent event) {
        textAreaComputer.setText(computer.getItemInteractionMessage());
        if(!textAreaComputer.isVisible()){
            computer.changeScore();
        }
        updateScoreText();
    }


    //Bedroom items
    @FXML
    void layInBed(MouseEvent event){
        String ChangeToMB = bed.getItemInteractionMessage();
        bed.changeScore();
        updateScoreText();
    }

    //Bathroom items
    @FXML
    void useToilet(MouseEvent event){
        String ChangeToMB = toilet.getItemInteractionMessage();
        toilet.changeScore();
        updateScoreText();
    }

    @FXML
    void useBath(MouseEvent event){
        String ChangeToMB = bath.getItemInteractionMessage();
        bath.changeScore();
        updateScoreText();
    }

    @FXML
    void useTV(MouseEvent event){
        String ChangeToMB = tv.getItemInteractionMessage();
        tv.changeScore();
        updateScoreText();
    }

    @FXML
    void readBook(MouseEvent event){
        String ChangeToMB = book.getItemInteractionMessage();
        book.changeScore();
        updateScoreText();
    }

    @FXML
    void lookOutWindow(MouseEvent event){
        String ChangeToMB = window.getItemInteractionMessage();
        window.changeScore();
        updateScoreText();
    }

    @FXML
    void exitDoor(MouseEvent event){
        String ChangeToMB = door.getItemInteractionMessage();
        door.changeScore();
        updateScoreText();
    }

    //Initializing the scoreText
    @FXML
    void initialize() {
    progressBar.setProgress(depressionBar.getScore());
    timeLabel.setText(time.getFullTime());
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
    }


    //METHODS
    public void changeRoom(String roomName, MouseEvent event) throws IOException, NullPointerException {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage)node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(roomName +".fxml"));
        thisStage.setTitle(roomName);
        thisStage.setScene(new Scene(root));
        timeline.stop();
        thisStage.show();
    }

    public void updateScoreText(){
        progressBar.setProgress(depressionBar.getScore());
    }

    Timeline timeline = new Timeline(
            new KeyFrame( Duration.seconds(3),
                    event -> {
                        timeLabel.setText(time.getFullTime());
                        time.addTime();
                    }
            )
    );
}
