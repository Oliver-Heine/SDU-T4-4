package worldOfZuulGui;

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
    gameOver("gameOver.fxml");

    private String fxml;

    Room(String fxml) {
        this.fxml = fxml;
    }

    public String getFxml() {
        return fxml;
    }
}
