package worldOfZuulGui.presentation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import worldOfZuulGui.domain.Item;
import worldOfZuulGui.domain.Room;
import worldOfZuulGui.domain.StatusScore;
import worldOfZuulGui.domain.TimeClass;

import java.io.IOException;
import java.net.URL;


public class Controller{

    //Singleton
    StatusScore depressionBar = StatusScore.getInstance();
    TimeClass time = TimeClass.getInstance();


    //Game information
    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label timeLabel;

    @FXML
    private MediaPlayer mediaPlayer;
    private Media media;
    URL MusicLocation;


    //Map
    @FXML
    private ImageView map;

    @FXML
    void showMap(KeyEvent event) {
        if(event.getCode().equals(KeyCode.M)){
            map.setVisible(true);
        }
    }

    @FXML
    void hideMap(KeyEvent event) {
        if(event.getCode().equals(KeyCode.M)){
            map.setVisible(false);
        }
    }

    //Item information text box
    @FXML
    private AnchorPane textBox;

    @FXML
    private TextArea itemInformation;

    @FXML
    void hideTextBox(MouseEvent event) throws IOException {
        textBox.setVisible(false);
        checkIfGameIsOver(event);
    }

    public void itemTextBoxShow(String itemInfo){
        textBox.setVisible(true);
        itemInformation.setText(itemInfo);
    }


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
            case "Fridge":
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
            case "Fridge":
            case "Entry":
                changeRoom(Room.Kitchen.name(), event);
                break;

        }
    }


    //Computer room button
    @FXML
    void goToComputerRoom(MouseEvent event) throws IOException {
        changeRoom(Room.Computer.name(), event);
    }

    //Fridge interactions

    //fries
    @FXML
    private Button interactFriesNeutral;
    @FXML
    private Button interactFriesNegative;
    @FXML
    private Button interactFriesPositive;
    //chicken
    @FXML
    private Button interactChickenNeutral;
    @FXML
    private Button interactChickenNegative;
    @FXML
    private Button interactChickenPositive;
    //beer
    @FXML
    private Button interactBeerNeutral;
    @FXML
    private Button interactBeerNegative;
    @FXML
    private Button interactBeerPositive;
    //water
    @FXML
    private Button interactWaterNeutral;
    @FXML
    private Button interactWaterNegative;
    @FXML
    private Button interactWaterPositive;

    @FXML
    private AnchorPane fridgeEnterPromptBox;

    @FXML
    void goToFrigheRoom(MouseEvent event) throws IOException{
        changeRoom(Room.Fridge.name(),event);
    }

    @FXML
    void checkScore(MouseEvent event) throws IOException{
        fridgeEnterPromptBox.setVisible(false);
        fridgeEnterPromptBox.setDisable(true);
        if (0.4 < depressionBar.getScore() && depressionBar.getScore() < 0.6) {
            interactFriesNeutral.setDisable(false);
            interactChickenNeutral.setDisable(false);
            interactBeerNeutral.setDisable(false);
            interactWaterNeutral.setDisable(false);
        }
        if (0.6 <= depressionBar.getScore()) {
            interactFriesPositive.setDisable(false);
            interactChickenPositive.setDisable(false);
            interactBeerPositive.setDisable(false);
            interactWaterPositive.setDisable(false);
        }
        if (0.4 >= depressionBar.getScore()) {
            interactFriesNegative.setDisable(false);
            interactChickenNegative.setDisable(false);
            interactBeerNegative.setDisable(false);
            interactWaterNegative.setDisable(false);
        }
    }

    //kitchen items:
    //fries
    Item friesNeutral = new Item("you it some fries you feel a bit bad",-0.05);
    Item friesPositive = new Item("You know fries ain't good for you so you only take some",0.0);
    Item friesNegative = new Item("you seem in a bad mood so you eat til you almost explode",-0.1);
    //chicken
    Item chickenNeutral = new Item("You make a satisfying meal out of a good chicken, you feel satisfied",0.05);
    Item chickenPositive = new Item("You make a perfect meal and feel amazing",0.1);
    Item chickenNegative = new Item("Because you feel bad you do not want to make a meal" +
            " but you still have to eat, so you make one, but you haven't been paying attention so the chicken is burnt." +
            " you feel very sad and still hungry",-0.1);
    //beer
    Item beerNeutral = new Item("You drink a cold one but have a very neutral mood so it does not affect your mood",0.0);
    Item beerPositive = new Item("You drink one and remember the Boys/girls and feel nostalgia, and a bit happy",0.5);
    Item beerNegative = new Item("You drink one and wonder if this covid19 will ever be over, and this lonely feeling will ever go away",-0.1);
    //water
    Item waterNeutral = new Item("it is water it is what you would expect",0.0);
    Item waterPositive = new Item("You drink water because you know it is good for you and you want to stay healthy, " +
            "so you feel energizes",0.1);
    Item waterNegative = new Item("YOU DRINK WATER AND WATER IS ALWAYS YOUR FRIEND",0.1);


    //kitchen use items
    //Fries
    @FXML
    void useNeutralFries(MouseEvent event)throws IOException {
        simpleItemInteraction(friesNeutral,event);
    }
    @FXML
    void useNegativeFries(MouseEvent event)throws IOException {
        simpleItemInteraction(friesNegative,event);
    }
    @FXML
    void usePositiveFries(MouseEvent event)throws IOException {
        simpleItemInteraction(friesPositive,event);
    }
    //chicken
    @FXML
    void useNeutralChicken(MouseEvent event)throws IOException {
        simpleItemInteraction(chickenNeutral,event);
    }
    @FXML
    void useNegativeChicken(MouseEvent event)throws IOException {
        simpleItemInteraction(chickenNegative,event);
    }
    @FXML
    void usePositiveChicken(MouseEvent event)throws IOException {
        simpleItemInteraction(chickenPositive,event);
    }
    //beer
    @FXML
    void useNeutralBeer(MouseEvent event)throws IOException {
        simpleItemInteraction(beerNeutral,event);
    }
    @FXML
    void useNegativeBeer(MouseEvent event)throws IOException {
        simpleItemInteraction(beerNegative,event);
    }
    @FXML
    void usePositiveBeer(MouseEvent event)throws IOException {
        simpleItemInteraction(beerPositive,event);
    }
    //water
    @FXML
    void useNeutralWater(MouseEvent event)throws IOException {
        simpleItemInteraction(waterNeutral,event);
    }
    @FXML
    void useNegativeWater(MouseEvent event)throws IOException {
        simpleItemInteraction(waterNegative,event);
    }
    @FXML
    void usePositiveWater(MouseEvent event)throws IOException {
        simpleItemInteraction(waterPositive,event);
    }

    //fridge close
    @FXML
    void hideTextBoxFridge(MouseEvent event) throws IOException {
        textBox.setVisible(false);
        checkIfGameIsOver(event);
        changeRoom(Room.Kitchen.name(), event);
    }


    //Bedroom items:
    Item bed = new Item();
    Item computer = new Item("You finished a voice chat with your friends, you feel good",-0.05);

    //Livingroom items:
    Item tv = new Item("You watch some tv",-0.05);
    Item book = new Item("You read in a book for some time",0.05);
    Item window = new Item("You stare out the window, sad that you can't go outside",-0.05);

    //Bathroom items:
    Item toilet = new Item("You use the toilet",0.05);
    Item bath = new Item("You take a nice long bath", 0.05);

    //Entrance items:
    Item door = new Item("You look at the door, and wonder what is outside",-0.05);



    //Bedroom items
    @FXML
    void layInBed(MouseEvent event) throws IOException {
        if(bed.getCanBeInteractedWith()){
            String timeSlept;
            simpleItemInteraction(bed,event);
            timeSlept = time.Sleep(depressionBar);
            updateScoreText();
            itemTextBoxShow("You slept "+timeSlept);
        }
    }


    //Computer room
    @FXML
    private TextArea textAreaComputer;

    @FXML
    void showComputerInfo(MouseEvent event) throws IOException {
        textAreaComputer.setText(computer.getItemInteractionMessage());
        if(textAreaComputer.isVisible()){
            textAreaComputer.setVisible(false);
        } else{
            textAreaComputer.setVisible(true);
        }
        if(textAreaComputer.isVisible()){
            computer.changeScore();
        }
        updateScoreText();
        checkIfGameIsOver(event);
    }


    //Bathroom items
    @FXML
    void useToilet(MouseEvent event) throws IOException {
        simpleItemInteraction(toilet,event);

    }

    @FXML
    void useBath(MouseEvent event) throws IOException {
        simpleItemInteraction(bath,event);
    }


    //Living room
    @FXML
    void useTV(MouseEvent event) throws IOException {
        simpleItemInteraction(tv,event);
    }

    @FXML
    void readBook(MouseEvent event) throws IOException {
        simpleItemInteraction(book,event);
    }

    @FXML
    void lookOutWindow(MouseEvent event) throws IOException {
        simpleItemInteraction(window,event);
    }


    //Entry
    @FXML
    void exitDoor(MouseEvent event) throws IOException {
        simpleItemInteraction(door,event);
    }


    //Initializing the scoreText
    @FXML
    void initialize() {
    progressBar.setProgress(depressionBar.getScore());
    timeLabel.setText(time.getFullTime());
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
    }


    //Change room
    public void changeRoom(String roomName, MouseEvent event) throws IOException, NullPointerException {
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage)node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/" + roomName +".fxml"));
        thisStage.setTitle(roomName);
        thisStage.setScene(new Scene(root));
        timeline.stop();
        thisStage.show();
    }

    public void updateScoreText(){
        progressBar.setProgress(depressionBar.getScore());
    }

    //Time
    Timeline timeline = new Timeline(
            new KeyFrame( Duration.seconds(3),
                    event -> {
                        timeLabel.setText(time.getFullTime());
                        time.addTime();
                    }
            )
    );


    //Method to check if game is over. Java use floating points for doubles and will not hit 0 as it should
    //therefore 0.001 and not 0.
    public void checkIfGameIsOver(MouseEvent event) throws IOException {
        if(depressionBar.getScore() >= 1){
            changeRoom(Room.gameWon.name(), event);
            depressionBar.setScore(0.5); //Resets the point-system after end game
            time.resetTime();

        }else if(depressionBar.getScore() <= 0.001||time.isTimeOut()){
            changeRoom(Room.gameLost.name(), event);
            depressionBar.setScore(0.5);
            time.resetTime();
        }
    }


    public void simpleItemInteraction(Item item, MouseEvent event) throws IOException {
        if(item.getCanBeInteractedWith()) {
            item.changeScore();
            updateScoreText();
            itemTextBoxShow(item.getItemInteractionMessage());
        }
    }
}

