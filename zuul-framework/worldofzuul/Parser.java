package worldofzuul;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Parser 
{
    private CommandWords commands; //commandwords object
    private Scanner reader; //scanner object

    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand()
    {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> "); //indikere at man kan skrive

        inputLine = reader.nextLine(); //user input

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next(); 
            }
        } //tager kommando (mellemrum) handling

        assert word1 != null;
        return new Command(commands.getCommandWord(word1.toLowerCase()), word2);
    }

    public void showCommands()
    {
        commands.showAll();
    }
}
