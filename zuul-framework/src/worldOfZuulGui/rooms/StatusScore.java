package worldOfZuulGui.rooms;

public class StatusScore {
    private double score;

    public StatusScore(){
        this.score = 0.5;
    }


    public double getScore() {
        return score;
    }


    public void changeScore(double change){
        score += change;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
