package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class Controller {

    //ROOMS
    @FXML
    private AnchorPane bedRoom;

    @FXML
    private AnchorPane computerRoom;

    @FXML
    private AnchorPane kitchenRoom;

    //Other text or stuff
    @FXML
    private TextArea textAreaComputer;

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
        changeVisability(textAreaComputer);
    }

    //METHODS
    public void changeRoom(AnchorPane fromRoom, AnchorPane toRoom){
        fromRoom.setVisible(false);
        toRoom.setVisible(true);
    }

    public void changeVisability(Control control){
        control.setVisible(!control.isVisible());
    }

}
