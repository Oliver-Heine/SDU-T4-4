package worldOfZuulGui;

public class StatusScore {
    private double score;
    private static StatusScore single_instance = null;

    private StatusScore(){
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

    public static StatusScore getInstance() {
            if (single_instance == null) {
                single_instance = new StatusScore();
            }
            return single_instance;
    }
}
