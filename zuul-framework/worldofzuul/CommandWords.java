package worldofzuul;
import java.util.HashMap;


public class CommandWords
{
    private HashMap<String, CommandWord> validCommands; //Private hashmap called "validCommands" that has the list of command words available in the CommandWord Class

    public CommandWords() //List of valid command words, if the command inputed by the user isnt unkown then it
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    public CommandWord getCommandWord(String commandWord) //Getter that checks if the command is unknown or
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    } //Checks if

    public void showAll()  //Method that shows all valid commands
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
