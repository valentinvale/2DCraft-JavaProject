import Blocks.*;
import Player.*;
import Items.*;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory(10);
        System.out.println(inventory.getItems().length);
        Player player = new Player("Player", 100, inventory);
        Block OakLeavesBlock = new Blocks.Leaves(0, "Oak Leaves", 100, "Oak.png", 0, 0);
        Block OakLogBlock = new Blocks.Log(1, "Oak Log", 100, "Oak.png", 0, 0);
        System.out.println(player.getInventory().getItems().length);
        OakLeavesBlock.dropItem(player);
        OakLogBlock.dropItem(player);
        player.getInventory().showInventory();


    }
}