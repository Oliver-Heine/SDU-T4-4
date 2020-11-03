package worldofzuul;

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

/*
class InteractableItem extends Item{

}
 */


class Items{
    public ArrayList<Item> items;

    Items (ArrayList<Item> items) {
        this.items = items;
    }
    Items () {
        this(new ArrayList<Item>());
    }

    public void addItem (Item item) {
        if (!items.contains(item)){
            items.add(item);
        }
    }

    public void removeItem (Item item) {
        items.remove(item);
    }

    public String printItems() {
        StringBuilder returnString = new StringBuilder("This room contains these items: ");
        for (int i = 0; i<items.size() ; i++) {
            returnString.append(", ").append(items.get(i).getItemName());
        }
        return returnString.toString();
    }
}