package worldOfZuulGui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;


public class Start extends Application {
    MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("rooms/" +Room.Bedroom.name() + ".fxml"));
        Scene scene1 = new Scene(root);

        Media media = new Media(new File("./resources/music/TestMusik.wav").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);



        primaryStage.setScene(scene1);
        primaryStage.setTitle("Bedroom");
        primaryStage.show();


    }

    public static void main(String[] args) {

        launch(args);
    }
}