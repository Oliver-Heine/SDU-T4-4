package worldofzuul;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"); //Commands that are available for the user
    
    private String commandString; //Private attribute that has the commandwords that are available
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    } //Constructor
    
    public String toString()
    {
        return commandString;
    } //toString method (a toString method returns values instead of where the values are stored in the memory)
}
