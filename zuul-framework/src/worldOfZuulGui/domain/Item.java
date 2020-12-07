package worldOfZuulGui.domain;

import worldOfZuulGui.domain.StatusScore;

public class Item {
    private double scoreChange;
    private String interactionMessage;
    private boolean canBeInteractedWith;

    StatusScore depressionBar = StatusScore.getInstance();

    public Item(String interactionMessage) {
        canBeInteractedWith = true;
        this.interactionMessage = interactionMessage;
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
