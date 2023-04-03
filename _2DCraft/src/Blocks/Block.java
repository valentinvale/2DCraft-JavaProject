package Blocks;
import Player.Player;
import Player.Inventory;

public abstract class Block {
    protected int id;
    protected String name;
    protected double durability;
    protected String texture;
    protected double x;
    protected double y;

    public Block(int id, String name, double durability, String texture, double x, double y) {
        this.id = id;
        this.name = name;
        this.durability = durability;
        this.texture = texture;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void dropItem(Player player);






}
