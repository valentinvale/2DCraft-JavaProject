package Blocks;

public class Leaves extends Block{

        public Leaves(int id, String name, double durability, String texture) {
            super(id, name, durability, texture);
        }

        @Override
        public void dropItem(Player.Player player, Player.Inventory inventory) {
            double random = Math.random();
            if(random < 0.5){
                player.getInventory().addItem(new Items.Leaves(1, "Leaves"));
            }
        }

}
