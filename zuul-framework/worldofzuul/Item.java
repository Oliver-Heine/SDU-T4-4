package worldofzuul;


public class Item {
    public String itemName;
    public String interactionMessage;
    public int statusScoreChange;

    public Item(String itemName, String interactionMessage, int statusScoreChange) {
        this.itemName = itemName;
        this.interactionMessage = interactionMessage;
        this.statusScoreChange = statusScoreChange;
    }

    public String getItemName (){
        return itemName;
    }

    public void itemInteraction(){
        StatusScore.ChangeScore(statusScoreChange);
        System.out.println(interactionMessage);
        System.out.println("Your status score is now: " + StatusScore.getScore());
    }

}

class Items{
    public Item[] itemsArray;

    public Items(Item[] itemsArray) {
        this.itemsArray = itemsArray;
    }

    public String printItems() {
        StringBuilder returnString = new StringBuilder("This room contains these items: ");
        for (int i = 0; i< itemsArray.length ; i++) {
            if(i == 0){
                returnString.append(itemsArray[i].itemName);
            }else{
                returnString.append(", ").append(itemsArray[i].itemName);
            }
        }
        return returnString.toString();
    }

    public Item[] getItemsArray() {
        return itemsArray;
    }
}