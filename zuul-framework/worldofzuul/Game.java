package worldofzuul;

import javax.swing.*;

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

        kitchen = new Room("in your kitchen", kitchenItems,0);
        bedroom = new Room("in your bedroom", roomItems,1);
        livingRoom = new Room("in your living room", livingRoomItems,2);
        bathroom = new Room("in your bathroom", bathroomItems,3);
        entrance = new Room("at the entrance", entranceItems,4);
        
        kitchen.setExit("bedroom", bedroom);
        kitchen.setExit("bathroom", bathroom);
        kitchen.setExit("livingroom", livingRoom);

        bedroom.setExit("kitchen", kitchen);

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
            if (StatusScore.gameOver())
            {
                finished = true;
                System.out.println("Thank you for playing. You lost because your score was zero or less. \n" +
                        "Play again and try to keep your score up.\n" +
                        "TIP: the score is your mental health");
            }
            else if(StatusScore.won())
            {
                finished = true;
                System.out.println("Thank you for playing. You won!");
            }
            else if(processCommand(command))
            {
                finished = true;
                System.out.println("Thank you for playing. You quit!");
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
        System.out.println("You are alone in your apartment during the Covid-19 pandemic.\n");
        System.out.println(currentRoom.getLongDescription());
        System.out.println("Live your day.\n Your command words are:");

        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            System.out.println("your options are");
            System.out.println(currentRoom.getExitString());
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
            System.out.println("your options are");
            System.out.println(currentRoom.items.printItems());
            return;
        }
        String interactableItem = command.getSecondWord();
        //Item[] item = currentRoom.getItem().itemsArray;
        int id = currentRoom.getRoomId();
        if (id == 0){
            switch (interactableItem.toLowerCase()) {
                //Kitchen items
                case "fridge" -> fridge.itemInteraction();
                case "freezer" -> freezer.itemInteraction();
                default -> System.out.println("This item is not in this room");
            }
        }else if(id==1){
            switch (interactableItem.toLowerCase()) {
                case "bed" -> bed.itemInteraction();
                case "computer" -> computer.itemInteraction();
                default -> System.out.println("This item is not in this room");
            }
        }else if(id==2){
            switch (interactableItem.toLowerCase()) {
                case "tv" -> tv.itemInteraction();
                default -> System.out.println("This item is not in this room");
            }
        }else if(id==3){
            switch (interactableItem.toLowerCase()) {
               case "toilet" -> toilet.itemInteraction();
                default -> System.out.println("This item is not in this room");
            }
        }else if(id==4){
        switch (interactableItem.toLowerCase()) {
            case "door" -> door.itemInteraction();
            default -> System.out.println("This item is not in this room");
        }
      }

        /*
        switch (interactableItem.toLowerCase()) {
            //Kitchen items
            case "fridge" -> fridge.itemInteraction();
            case "freezer" -> freezer.itemInteraction();
            //Room items
            case "bed" -> bed.itemInteraction();
            case "computer" -> computer.itemInteraction();
            //Living room items
            case "tv" -> tv.itemInteraction();
            //Bathroom items
            case "toilet" -> toilet.itemInteraction();
            //Entrance items
            case "door" -> door.itemInteraction();
            //Default
            default -> System.out.println("This item is not in this room");

        }*/

    }
    //Kitchen items:
    Item fridge = new Item("fridge","You open the fridge and get some food",5);
    Item freezer = new Item("freezer", "You open the freezer and eat some ice cream!", 5);
    Item[] kitchenItemsArray = {fridge,freezer};
    Items kitchenItems = new Items(kitchenItemsArray);

    //room items:
    Item bed = new Item("bed","You lay in your bed",5);
    Item computer = new Item("computer","You play on the computer",5);
    Item[] roomItemsArray = {bed,computer};
    Items roomItems = new Items(roomItemsArray);


    //living room items:
    Item tv = new Item("tv","You watch some tv",-5);
    Item[] livingRoomItemsArray = {tv};
    Items livingRoomItems = new Items(livingRoomItemsArray);


    //bathroom items:
    Item toilet = new Item("toilet","You use the toilet",5);
    Item[] bathroomItemsArray = {toilet};
    Items bathroomItems = new Items(bathroomItemsArray);


    //Entrance items:
    Item door = new Item("door","You go for a short walk",5);
    Item[] entranceItemsArray = {door};
    Items entranceItems = new Items(entranceItemsArray);

}
