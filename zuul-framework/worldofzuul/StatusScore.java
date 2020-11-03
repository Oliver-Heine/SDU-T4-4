package worldofzuul;

public class StatusScore {
    private static int score = 50;

    public void increaseScore() {
        score += 2;
    }

    public void increaseScore(int num) {
        score += num;
    }

    public void decreaseScore() {
        score -= 2;
    }

    public void decreaseScore(int num) {
        score -= num;
    }

    public void setScore(int num) {
        score = num;
    }

    public int getScore() {
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

