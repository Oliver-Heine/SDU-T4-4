package worldOfZuulGui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URISyntaxException;


public class Start extends Application {
    MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("rooms/" +Room.Bedroom.name() + ".fxml"));
        Scene scene1 = new Scene(root);
        try {
            String musicPath = StatusScore.class.getResource("/music/TestMusik.wav").toURI().toString();
            mediaPlayer = new MediaPlayer(new Media(musicPath));
            mediaPlayer.play();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Bedroom");
        primaryStage.show();


    }

    public static void main(String[] args) {

        launch(args);
    }
}