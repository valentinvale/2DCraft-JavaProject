package Blocks;

public class Planks extends Block{
    public Planks(int id, String name, double durability, String texture, double x, double y) {
        super(id, name, durability, texture, x, y);
    }

    @Override
    public void dropItem(Player.Player player) {
        player.getInventory().addItem(new Items.Planks(1, this.getName()));
    }
}
