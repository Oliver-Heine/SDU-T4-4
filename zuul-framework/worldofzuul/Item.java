package worldofzuul;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;


public class Item {
    public String itemName;

    Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName (){
        return itemName;
    }
}

class ItemFunctions{

    //Functions for all the items:

    //Kitchen item interactions
    public static void fridgeInteraction(){
        StatusScore.increaseScore(10);
        System.out.println("You open the fridge and get some food");
    }
    public static void freezerInteraction(){
        StatusScore.decreaseScore(25);
        System.out.println("You open the freezer and eat some ice cream!");
    }

    //Bathroom item interactions
    public static void bedInteraction(){
        StatusScore.increaseScore(10);
        System.out.println("You lay in your bed");
    }

    public static void computerInteraction(){
        StatusScore.decreaseScore(25);
        System.out.println("You play on the computer");
    }

    //Living room item interactions
    public static void tvInteraction(){
        StatusScore.decreaseScore(20);
        System.out.println("You watch some tv");
    }

    //Bathroom item interactions
    public static void toiletInteraction(){
        StatusScore.increaseScore(15);
        System.out.println("You use the toilet");
    }

    //Entrance item interactions
    public static void doorInteraction(){
        StatusScore.increaseScore(20);
        System.out.println("You go for a short walk");
    }
}

class Items{
    public Item[] itemsArray;

    public Items(Item[] itemsArray) {
        this.itemsArray = itemsArray;
    }

    public String printItems() {
        StringBuilder returnString = new StringBuilder("This room contains these items: ");
        for (int i = 0; i< itemsArray.length ; i++) {
            if(i == 0){
                returnString.append(itemsArray[i].itemName);
            }else{
                returnString.append(", ").append(itemsArray[i].itemName);
            }
        }
        return returnString.toString();
    }

    public Item[] getItemsArray() {
        return itemsArray;
    }
}