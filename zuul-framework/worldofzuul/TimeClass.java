package worldofzuul;

import java.util.concurrent.TimeUnit;

public class TimeClass {
    private static int time;

    private static int DayNumber = 0;


    public static void TimeChecker() {
        if (time <= 25) {
            DayNumber++;

        } else
            time++;


    }


    public static void TimeCounter () throws InterruptedException {
        for (int time = 0; time<25;time++){
            TimeChecker();
            dayNumbers();
            TimeUnit.SECONDS.sleep(60); //Ændrer for hurtigere or langsomere output
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


