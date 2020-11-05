package worldofzuul;

public class Game
{
    private Parser parser; //parser attribute
    private Room currentRoom; //room attribute

    public Game() //game constructor
    {
        createRooms(); //create rooms function
        parser = new Parser(); //create parser object
    }

    private void createRooms()
    {
        Room kitchen, bedroom, livingRoom, bathroom, entrance;

        kitchen = new Room("in your kitchen", kitchenItems);
        bedroom = new Room("in your bedroom", roomItems);
        livingRoom = new Room("in your living room", livingRoomItems);
        bathroom = new Room("in your bathroom", bathroomItems);
        entrance = new Room("at the entrance", entranceItems);
        
        kitchen.setExit("bedroom", bedroom);
        kitchen.setExit("bathroom", bathroom);
        kitchen.setExit("livingroom", livingRoom);

        bedroom.setExit("kitchen", livingRoom);

        livingRoom.setExit("kitchen", kitchen);
        livingRoom.setExit("entrance", entrance);
        livingRoom.setExit("bedroom", bedroom);

        entrance.setExit("bathroom", bathroom);
        entrance.setExit("livingroom", livingRoom);

        bathroom.setExit("entrance", entrance);


        currentRoom = bedroom;
    }


    public void play()
    {
        printWelcome();
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            StatusScore end = new StatusScore();
            if (processCommand(command)|| end.gameOver())
            {
                finished = processCommand(command)|| end.gameOver();
                System.out.println("Thank you for playing. You lost because your score was zero or less. " +
                        "Play again and try to keep your score up." +
                        "TIP: the score is your mental health");
            }
            else if(end.won())
            {
                finished = true;
                System.out.println("Thank you for playing. You won!");
            }

        }
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println("Interact with an item by typing \"Interact ItemName\"");
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
        else if (commandWord == CommandWord.INTERACT) {
            //System.out.println("interact works");
            interactItem(command);
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

    private void interactItem(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Interact with what?");
            return;
        }
        String interactableItem = command.getSecondWord();
        //Item[] item = currentRoom.getItem().itemsArray;

        switch (interactableItem.toLowerCase()) {
            //Kitchen items
            case "fridge" -> ItemFunctions.fridgeInteraction();
            case "freezer" -> ItemFunctions.freezerInteraction();
            //Room items
            case "bed" -> ItemFunctions.bedInteraction();
            case "computer" -> ItemFunctions.computerInteraction();
            //Living room items
            case "tv" -> ItemFunctions.tvInteraction();
            //Bathroom items
            case "toilet" -> ItemFunctions.toiletInteraction();
            //Entrance items
            case "door" -> ItemFunctions.doorInteraction();
            //Default
            default -> System.out.println("This item is not in this room");
        }

    }
    //Kitchen items:
    Item fridge = new Item("fridge");
    Item freezer = new Item("freezer");
    Item[] kitchenItemsArray = {fridge,freezer};
    Items kitchenItems = new Items(kitchenItemsArray);

    //room items:
    Item bed = new Item("bed");
    Item computer = new Item("computer");
    Item[] roomItemsArray = {bed,computer};
    Items roomItems = new Items(roomItemsArray);

    //living room items:
    Item tv = new Item("tv");
    Item[] livingRoomItemsArray = {tv};
    Items livingRoomItems = new Items(livingRoomItemsArray);

    //bathroom items:
    Item toilet = new Item("toilet");
    Item[] bathroomItemsArray = {toilet};
    Items bathroomItems = new Items(bathroomItemsArray);

    //Entrance items:
    Item door = new Item("door");
    Item[] entranceItemsArray = {door};
    Items entranceItems = new Items(entranceItemsArray);
}
