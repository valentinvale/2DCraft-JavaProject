package Blocks;

public class Leaves extends Block{

        public Leaves(int id, String name, double durability, String texture, double x, double y) {
            super(id, name, durability, texture, x, y);
        }

        @Override
        public void dropItem(Player.Player player) {
            double random = Math.random();
            String name = this.getName().substring(0, this.getName().indexOf(" "));
            if(random < 0.5){
                player.getInventory().addItem(new Items.Sapling(0, name + " Sapling"));
            }
        }

}
