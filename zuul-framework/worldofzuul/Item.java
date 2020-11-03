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

    InteractableItem(String itemName) {
        super(itemName);
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
}