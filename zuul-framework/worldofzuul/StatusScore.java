package worldofzuul;

public class StatusScore {
    private static int score = 50;

    public static void increaseScore() {
        score += 2;
    }

    public static void increaseScore(int num) {
        score += num;
    }

    public static void decreaseScore() {
        score -= 2;
    }

    public static void decreaseScore(int num) {
        score -= num;
    }

    public static void setScore(int num) {
        score = num;
    }

    public static int getScore() {
        return score;
    }

    public boolean gameOver() {
        if(score<=0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean won() {
        if (score>=100) {
            return true;
        } else {
            return false;
        }
    }
}

