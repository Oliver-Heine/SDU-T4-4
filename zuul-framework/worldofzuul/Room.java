package worldofzuul;

import java.util.Set;
import java.util.HashMap;


public class Room
{
    //Attributes
    private String description;
    private HashMap<String, Room> exits;
//Constructor
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }
//Setter for exit
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    //Method that gets invoked when going int to
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
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
//Getter for exit with the directions as parameter
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

