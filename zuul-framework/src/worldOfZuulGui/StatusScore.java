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

    /**
     * This method increases the score by the amount given
     * @param change the amount the score is increased by
     */
    public void changeScore(double change){
        score += change;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Method for getting instance of StatusScore Singleton
     * @return Instance of statusScore
     */
    public static StatusScore getInstance() {
            if (single_instance == null) {
                single_instance = new StatusScore();
            }
            return single_instance;
    }
}
