package worldOfZuulGui.domain;

public enum Room {
    Entry("entry.fxml"),
    Kitchen("kitchen.fxml"),
    LivingRoom("livingRoom.fxml"),
    Bedroom("bedRoom.fxml"),
    BathRoom("bathroom.fxml"),
    Computer("computer.fxml"),
    StartMenu("StartMenu.fxml"),
    StartScreen("StartScreen.fxml"),
    Tutorial("Tutorial.fxml"),
    Tutorial_2("Tutorial_2.fxml"),
    Tutorial_3("Tutorial_3.fxml"),
    Tutorial_4("Tutorial_4.fxml"),
    gameLost("gameLost.fxml"),
    gameWon("gameWon.fxml"),
    Fridge("fridge.fxml");

    private String fxml;

    Room(String fxml) {
        this.fxml = fxml;
    }

    public String getFxml() {
        return fxml;
    }
}
