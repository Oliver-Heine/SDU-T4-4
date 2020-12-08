package worldOfZuulGui.domain;

import worldOfZuulGui.domain.StatusScore;

public class Item {
    private double scoreChange;
    private String interactionMessage;
    private boolean canBeInteractedWith;
    private int timeChange;

    StatusScore depressionBar = StatusScore.getInstance();

    public Item() {
        canBeInteractedWith = true;
    }

    public Item(String interactionMessage) {
        canBeInteractedWith = true;
        this.interactionMessage = interactionMessage;
    }

    public Item() {
        canBeInteractedWith = true;
    }

    public Item(String interactionMessage, double scoreChange, int timeChange){
        this.scoreChange = scoreChange;
        this.interactionMessage = interactionMessage;
        this.timeChange = timeChange;
        canBeInteractedWith = true;
    }

    public double getScoreChange(){
        return scoreChange;
    }

    public void changeScore(){
            depressionBar.changeScore(scoreChange);
            canBeInteractedWith = false;
    }
    public void changeScore(double score){
        depressionBar.changeScore(score);
        canBeInteractedWith = false;
    }

    public int getTimeChange() {
        return timeChange;
    }

    public String isItemInteractionMessage() {
        return interactionMessage;
    }

    public boolean getCanBeInteractedWith() {
        return canBeInteractedWith;
    }
}
