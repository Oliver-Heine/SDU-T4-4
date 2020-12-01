package worldOfZuulGui;

public enum Room {
    Kitchen("kitchen.fxml"),
    Bedroom("bedroom.fxml"),
    Computer("computer.fxml"),
    livingRoom("livingRoom.fxml"),
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
