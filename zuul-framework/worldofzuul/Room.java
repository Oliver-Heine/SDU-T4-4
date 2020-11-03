package worldofzuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;


public class Room
{
    private String description;
    private HashMap<String, Room> exits;
    Items items;

    public Room(String description, Items items)
    {
        this.description = description;
        this.items = items;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + items.printItems() + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public Items getItem()
    {
        return items;
    }
}

