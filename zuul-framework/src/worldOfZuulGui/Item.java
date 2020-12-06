package worldOfZuulGui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Item {
    private int time;
    private double scoreChange;
    private String interactionMessage;
    private boolean canBeInteractedWith;

    StatusScore depressionBar = StatusScore.getInstance();

    public Item(int time, int scoreChange, String interactionMessage) {
        this.time = time;
        this.scoreChange = scoreChange;
        canBeInteractedWith = true;
    }

    public Item(String interactionMessage, double scoreChange){
        this.scoreChange = scoreChange;
        this.interactionMessage = interactionMessage;
        canBeInteractedWith = true;
    }

    public double getScoreChange(){
        return scoreChange;
    }

    public void changeScore(){
            depressionBar.changeScore(scoreChange);
            canBeInteractedWith = false;
    }

    public String getItemInteractionMessage() {
        return interactionMessage;
    }

    public boolean getCanBeInteractedWith() {
        return canBeInteractedWith;
    }
}
