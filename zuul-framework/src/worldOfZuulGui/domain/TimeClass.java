package worldOfZuulGui.domain;


import java.sql.Time;

public class TimeClass {

    private int time;
    private int dayNumber;
    private String dayName;
    private static String TimeString="";
    private static TimeClass single_instance = null;
    private boolean timeOut = false;

    TimeClass(int time, int dayNumber, String dayName){
        this.time = time;
        this.dayNumber = dayNumber;
        this.dayName = dayName;
    }

    public int getTime() {
        return time;
    }

    public String getFullTime(){
        return "Hour of day: " + time + " | " + " Day: " + dayChecker(dayNumber);
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public String getDayName() {
        return dayName;
    }

    public void addTime() {
        time++;
        timeChecker();
        TimeString = Integer.toString(time);
    }

    public void timeChecker() {
        if (time == 24) {
            dayNumber++;
            time = 0;
        }
    }

    public String dayChecker(int dayNum) {
        if (dayNum == 1) {
            return "Monday";
        } else if (dayNum == 2) {
            return  "Tuesday";
        } else if (dayNum == 3) {
            return "Wednesday";
        } else if (dayNum == 4) {
            return "Thursday";
        } else if (dayNum == 5) {
            return "Friday";
        } else if (dayNum == 6) {
            return "Saturday";
        } else if (dayNum == 7) {
            return "Sunday";
        }
        timeOut = true;
        return "Time Out";
    }

    public boolean isTimeOut() {
        return timeOut;
    }

    public static TimeClass getInstance() {
        if (single_instance == null) {
            single_instance = new TimeClass(0,1,"Monday");
        }
        return single_instance;
    }

    public static String getTimeString(){
        return TimeString;
    }

    public String Sleep(StatusScore score){
        double ScoreNow = score.getScore();
        int timePenalty;
        if(ScoreNow<0.1){
            timePenalty = 5;
        }else if(0.1<=ScoreNow && ScoreNow<0.4){
            timePenalty = 3;
        }else if(0.5<=ScoreNow && ScoreNow<0.7){
            timePenalty = 1;
        }else {
            timePenalty = 0;
        }

        if (time>=20 && time<=22){
            timePasses(6 + timePenalty);
            score.changeScore(0.05);
            return 8 + timePenalty +" hours and feel refreshed";
        }
        else if(time>=23 && time<=24){
            timePasses(10+timePenalty);
            dayNumber++;
            return 10+timePenalty+" hours and feel refreshed";
        }
        else if(time>=0 && time<=6){
            timePasses(12+timePenalty); //sleep 10 hours plus penalty
            score.changeScore(-0.1);
            return 12+timePenalty+" hours and don't want to wake up, because you feel lazy.";
        }
        else{
            score.changeScore(-0.2);
            return 0+" hours since you are not tired.";
        }
    }

    public void timePasses(int timePassing){
        int currentTime = time;
        currentTime = currentTime + timePassing;
        if(currentTime > 24){
            time = currentTime - 24;
            dayNumber++;
        } else {
            time = currentTime;
        }
    }

    public void resetTime(){
        time = 0;
        dayNumber = 1;
        dayName = "Monday";
    }

}