package worldOfZuulGui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import worldOfZuulGui.domain.Room;

import java.io.File;


public class Start extends Application {
    MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource( "./fxml/" + Room.StartScreen.name() + ".fxml"));

        Media media = new Media(new File("./resources/music/TestMusik.wav").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        Scene scene1 = new Scene(root);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("StartScreen");
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}