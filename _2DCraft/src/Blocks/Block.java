package Blocks;
import Player.Player;
import Player.Inventory;

public abstract class Block {
    private int id;
    private String name;
    private double durability;
    private String texture;

    public Block(int id, String name, double durability, String texture) {
        this.id = id;
        this.name = name;
        this.durability = durability;
        this.texture = texture;
    }

    public abstract void dropItem(Player player, Inventory inventory);






}
