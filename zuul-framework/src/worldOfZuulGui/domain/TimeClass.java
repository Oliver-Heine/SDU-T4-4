package worldOfZuulGui.domain;


public class TimeClass {

    private int time;
    private int dayNumber;
    private String dayName;
    private static String TimeString="";
    private static TimeClass single_instance = null;

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
        return "No more days";
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

}