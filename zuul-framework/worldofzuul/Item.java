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

class InteractableItem extends Item{

    String interactionText;

    InteractableItem(String itemName, String interactionText) {
        super(itemName);
        this.interactionText = interactionText;
    }

    public void interactionWithItem(){
        // score metode here
        System.out.println("You interacted with the item");
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
            returnString.append(", ").append(itemsArray[i].itemName);
        }
        return returnString.toString();
    }

    public Item[] getItemsArray() {
        return itemsArray;
    }
}