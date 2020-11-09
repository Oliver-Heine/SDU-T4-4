package worldofzuul;



public class TimeClass {

    private static int time=23;
    private static int dayNumber = 0;
    private static String dayName = "Monday";

    public static void addTime(){
        time++;
        timeChecker();
        dayChecker();
    }

    public static void timeChecker() {
        if (time==24){
        dayNumber++;
        time=0;
}
    }

    public static void dayChecker(){
        if (dayNumber == 1 && time == 0) {
            System.out.println("It's a new day:  MONDAY");
            dayName= "Monday";
        } else if (dayNumber == 2 && time == 0) {
            System.out.println("It's a new day:  TUESDAY");
            dayName= "Tuesday";
        } else if (dayNumber == 3 && time == 0) {
            System.out.println("It's a new day:  WEDNESDAY");
            dayName="WEDNESDAY";
        } else if (dayNumber == 4 && time == 0) {
            System.out.println("It's a new day:  THURSDAY");
            dayName="Thursday";
        } else if (dayNumber == 5 && time == 0) {
            System.out.println("It's a new day:  FRIDAY");
            dayName="Friday";
        } else if (dayNumber == 6 && time == 0) {
            System.out.println("It's a new day:  SATURDAY");
            dayName="Saturday";
        } else if (dayNumber == 7 && time == 0) {
            System.out.println("It's a new day:  SUNDAY");
            dayName="Sunday";
        }
    }

    public static void getTime(){
        System.out.println("You are in the "+time+ "th hour");
        System.out.println("Today is " + dayName);
    }


}


