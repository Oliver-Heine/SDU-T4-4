package sample;

public class StatusScore {
    private int score = 50;

    public int getScore() {
        return score;
    }

    public void changeScore(int change){
        score += change;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
