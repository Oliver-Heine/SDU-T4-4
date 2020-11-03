package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room bedroom, livingRoom, kitchen, bathroom, entrance;
      //Description of rooms (Changes pending!)
        bedroom = new Room("awake and in your bedroom and you see " + /*plus with bedroom-items*/ " and you can interact with "
                /*plus with bedroom-Intractable items*/);
        livingRoom = new Room("in your living room and you see " + /*plus with livingroom-items*/ " and you can interact with "
                /*plus with bedroom-Intractable items*/);
        kitchen = new Room("in your kitchen and you see " + /*plus with kitchen-items*/ " and you can interact with "
                /*plus with bedroom-Intractable items*/);
        bathroom = new Room("in your bathroom and you see " + /*plus with bathroom-items*/ " and you can interact with "
                /*plus with bedroom-Intractable items*/);
        entrance = new Room("in your entrance and you see " + /*plus with entrance-items*/ "and you can interact with "
                /*plus with bedroom-Intractable items*/);


        //Exits / entrances from rooms starting at bedroom
        bedroom.setExit("livingroom", livingRoom);

        livingRoom.setExit("bedroom", bedroom);
        livingRoom.setExit("kitchen", kitchen);
        livingRoom.setExit("entrance", entrance);

        kitchen.setExit("livingroom", livingRoom);
        kitchen.setExit("entrance", entrance);

        entrance.setExit("kitchen", kitchen);
        entrance.setExit("livingroom", livingRoom);
        entrance.setExit("bathroom", bathroom);

        bathroom.setExit("entrance", entrance);

        //Room where you start
        currentRoom = bedroom;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
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

    private void printHelp() 
    {
        System.out.println("You are alone in your apartment during the Covid-19 pandemic.");
        System.out.println("Live your day.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
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
