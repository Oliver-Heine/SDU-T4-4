package worldofzuul;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Parser 
{
    private CommandWords commands; //commandwords object
    private Scanner reader; //scanner object

    //Constructor
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() // Overall a method that reads input from user. If input from user doesnt have any element then it cant continue
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> "); //Indication that informs user that input is now available
        inputLine = reader.nextLine(); //user input

        Scanner tokenizer = new Scanner(inputLine); // Scanner that reads input from user
        if(tokenizer.hasNext()){ // Checks if it has any element to scan, if it has (true) then the user can proceed to type
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) { //Same as above
                word2 = tokenizer.next(); 
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    public void showCommands()
    {
        commands.showAll();
    } // Shows all commands (is included in the printHelp method) (Comes from the CommandWords Class)
}
