package Player;

public class Player {

    private String name;
    private int health;
    private Inventory inventory;

    public Player(String name, int health, Inventory inventory) {
        this.name = name;
        this.health = health;
        this.inventory = new Inventory(inventory.getSize());
    }

    public Inventory getInventory() {
        return inventory;
    }

}
