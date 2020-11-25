package sample;

public class StatusScore {
    private static int score = 50;

    public static int getScore() {
        return score;
    }

    public static void changeScore(int change){
        score += change;
    }

    public void setScore(int score) {
        StatusScore.score = score;
    }
}
