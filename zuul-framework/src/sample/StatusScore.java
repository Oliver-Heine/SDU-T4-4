package sample;

public class StatusScore {
    private static double score = 0.5;

    public static double getScore() {
        return score;
    }

    public static void changeScore(double change){
        score += change;
    }

    public void setScore(int score) {
        StatusScore.score = score;
    }
}
