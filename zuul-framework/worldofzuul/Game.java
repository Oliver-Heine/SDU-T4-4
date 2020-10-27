package worldofzuul;

public class Game 
{
    private Parser parser; //parser attribut
    private Room currentRoom; //room attribut

    public Game() //game constructor
    {
        createRooms(); //create rooms function
        parser = new Parser(); //creates parser object
    }


    private void createRooms()    //The rooms that will be created! (Add rooms needed for the project here!)
    {
        Room outside, theatre, pub, lab, office;
      
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;
    }

    public void play() //Method that prints game introduction and
    {            
        printWelcome();

                
        boolean finished = false; //Sets that the game is still running
        while (! finished) {
            Command command = parser.getCommand(); // While the game is not finished read input from user (Check getCommand in parser class)
            finished = processCommand(command);  // Game is finished when processCommand(command)is true (wantToQuit is the deciding factor in the processCommand method)
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() //Game introduction which is included in play method
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help."); // Reference to CommandWord class which has the commandstring "help"
        System.out.println();
        System.out.println(currentRoom.getLongDescription()); //Gets description of current room
    }

    private boolean processCommand(Command command)  /* Method that processes unknown commands and  go, quit, help*/
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp()  /*This methods gets invoked when typing help in the console (is included in the processCommand method)*/
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands(); //Prints commands available
    }

    private void goRoom(Command command)  //Overall a method that controls the directions of the player
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?"); //if the commandword "go" doesnt has a second word then it prints go where
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) { // If a another room cant be found then it prints "There is no door"
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command)  //Method that checks if the word quit has a word included after it, if it doenst then it returns a true value which stops the game (wantToQuit)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
