package worldOfZuulGui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("rooms/" +Room.Bedroom.name() + ".fxml"));

        Scene scene1 = new Scene(root);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Bedroom");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}