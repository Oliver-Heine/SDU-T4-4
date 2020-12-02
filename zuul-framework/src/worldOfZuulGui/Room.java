package worldOfZuulGui;

public enum Room {
    Entry("entry.fxml"),
    Kitchen("kitchen.fxml"),
    LivingRoom("livingRoom.fxml"),
    Bedroom("bedRoom.fxml"),
    BathRoom("bathroom.fxml"),
    Computer("computer.fxml"),
    menu("menu.fxml"),
    gameOver("gameOver.fxml");

    private String fxml;

    Room(String fxml) {
        this.fxml = fxml;
    }

    public String getFxml() {
        return fxml;
    }
}
