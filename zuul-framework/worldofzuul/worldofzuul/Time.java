package worldofzuul;

public class Time {
    private int hour=0;
    private static int hoursInAday =24;
    private String[] day;

 public static int hourss(int hour){
     do{
         hour++;
     }while(hour<hoursInAday);
     System.out.println(hour);
     return hour;
 }

}