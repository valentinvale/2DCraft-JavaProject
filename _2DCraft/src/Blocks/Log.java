package Blocks;
public class Log extends Block{

        public Log(int id, String name, double durability, String texture, double x, double y) {
            super(id, name, durability, texture, x, y);
        }

        @Override
        public void dropItem(Player.Player player) {
            player.getInventory().addItem(new Items.Log(1, this.getName()));
        }
}
