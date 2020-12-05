package worldOfZuulGui.rooms;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import worldOfZuulGui.Room;
import worldOfZuulGui.StatusScore;
import worldOfZuulGui.TimeClass;
import javafx.scene.media.MediaView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

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
    @FXML
    private MediaPlayer mediaPlayer;
    private Media media;


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        media = new Media (Controller.class.getResource("/TestMusik.wav").toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}

