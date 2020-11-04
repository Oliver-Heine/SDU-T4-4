package worldofzuul;

public class Game
{
    private Parser parser; //parser attribut
    private Room currentRoom; //room attribut

    public Game() //game constructor
    {
        createRooms(); //create rooms funktion
        parser = new Parser(); //create parser object
    }

    private void createRooms()
    {
        Room kitchen, room, living_room, bathroom, entrance;

        kitchen = new Room("You are in the kitchen", kitchenItems);
        room = new Room("in your room", roomItems);
        living_room = new Room("in the living_room", livingRoomItems);
        bathroom = new Room("in a bathroom", bathroomItems);
        entrance = new Room("The entrance", entranceItems);
        
        kitchen.setExit("east", room);
        kitchen.setExit("south", bathroom);
        kitchen.setExit("west", living_room);

        room.setExit("west", kitchen);

        living_room.setExit("east", kitchen);

        bathroom.setExit("north", kitchen);
        bathroom.setExit("east", entrance);

        entrance.setExit("west", bathroom);

        currentRoom = kitchen;
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
                System.out.println("Thank you for playing. You lost.");
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
