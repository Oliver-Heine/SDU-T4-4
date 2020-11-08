package worldofzuul;

import java.util.concurrent.TimeUnit;

public class TimeClass {
    private static int time;

    private static int DayNumber = 0;


    public static void TimeChecker() { // When time gets incremented to 24 then DayNumber gets incremented by 1
        if (time <= 25) {
            DayNumber++;

        } else
            time++;


    }


    public static void TimeCounter () throws InterruptedException { /*Heart of this class, This method prints out from 0 to 24, and connects the two other methods*/
        for (int time = 0; time<25;time++){
            TimeChecker();
            dayNumbers();
            TimeUnit.SECONDS.sleep(60); //Change this value for faster or slower time output!
            System.out.println("The clock is "+time + " : 00");



        }
    }
    public static void dayNumbers () throws InterruptedException {

        switch (DayNumber) {
            case 7 -> {
                TimeCounter();
                System.out.println("NEW DAY : MONDAY"+ "\n");
                TimeChecker();

            }
            case 6 -> {
                TimeCounter();
                System.out.println("NEW DAY : TUESDAY"+ "\n");
                TimeChecker();

            }
            case 5 -> {
                TimeCounter();
                System.out.println("NEW DAY : WEDNESDAY"+ "\n");
                TimeChecker();

            }
            case 4 -> {
                TimeCounter();
                System.out.println("NEW DAY : THURSDAY"+ "\n");
                TimeChecker();



            }
            case 3 -> {
                TimeCounter();
                System.out.println("NEW DAY : FRIDAY"+ "\n");
                TimeChecker();

            }
            case 2 -> {

                TimeCounter();
                System.out.println("NEW DAY : SATURDAY"+ "\n");
                TimeChecker();

            }
            case 1 -> {

                TimeCounter();
                System.out.println("NEW DAY : SUNDAY" + "\n");
                TimeChecker();

            }
        }
    }

}


