package worldOfZuulGui.domain;


import java.sql.Time;

public class TimeClass {

    private int time;
    private int dayNumber;
    private String dayName;
    private int lastTimeSlept;
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
        int TimePenalty;
        if(ScoreNow<0.1){
            TimePenalty = 5;
        }else if(0.1<=ScoreNow && ScoreNow<0.4){
            TimePenalty = 3;
        }else if(0.5<=ScoreNow && ScoreNow<0.7){
            TimePenalty = 1;
        }else {
            TimePenalty = 0;
        }

        if (time>=20 && time<=22){
            time=6 + TimePenalty; //sleep 8 hours plus penalty
            dayNumber++;
            lastTimeSlept = time;
            score.changeScore(0.05);
            return 8 + TimePenalty +" hours and feel refreshed";
        }
        else if(time>=23 && time<=24){
            time=10+TimePenalty; //sleep 10 hours plus penalty
            lastTimeSlept = time;
            dayNumber++;
            return 10+TimePenalty+" hours and feel refreshed";
        }
        else if(time>=1 && time<=6){
            time+=12+TimePenalty; //sleep 10 hours plus penalty
            lastTimeSlept = time;
            score.changeScore(-0.1);
            return 12+TimePenalty+" hours and don't want to wake up, because you feel lazy.";
        }
        else{
            score.changeScore(-0.2);
            return 0+" hours since you are not tired.";
        }

    }

    public void resetTime(){
        time = 0;
        dayNumber = 1;
        dayName = "Monday";
    }

}