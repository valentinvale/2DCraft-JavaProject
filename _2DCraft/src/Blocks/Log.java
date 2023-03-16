package Blocks;
public class Log extends Block{

        public Log(int id, String name, double durability, String texture) {
            super(id, name, durability, texture);
        }

        @Override
        public void dropItem(Player.Player player, Player.Inventory inventory) {
            player.getInventory().addItem(new Items.Log(1, "Log"));
        }
}
