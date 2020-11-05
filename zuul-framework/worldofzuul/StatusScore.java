package worldofzuul;

public class StatusScore {
    private static int score = 50;

    public static void ChangeScore(int num) {
        score += num;
    }

    public static void setScore(int num) {
        score = num;
    }

    public static int getScore() {
        return score;
    }

    public static boolean gameOver() {
        if(score<=0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean won() {
        if (score>=100) {
            return true;
        } else {
            return false;
        }
    }
}

