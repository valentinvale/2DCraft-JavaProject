import Blocks.*;
import Player.*;
import Items.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Player> playerList = new HashSet<>();

        Inventory inventory = new Inventory(20);
        System.out.println(inventory.getItems().length);
        Player player = new Player("Player", 100, inventory);
        playerList.add(player);
        Block OakLeavesBlock = new Blocks.Leaves(0, "Oak Leaves", 100, "Oak.png", 0, 0);
        Block OakLogBlock = new Blocks.Log(1, "Oak Log", 100, "Oak.png", 0, 0);
        System.out.println(player.getInventory().getItems().length);
        OakLeavesBlock.dropItem(player);
        OakLogBlock.dropItem(player);
        OakLogBlock.dropItem(player);
        OakLogBlock.dropItem(player);
        OakLogBlock.dropItem(player);
        player.getInventory().showInventory();

        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Log"), 1);
        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Log"), 2);
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Log"), 3);
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Log"), 4);
        player.getInventory().showInventory();
//
        player.getInventory().removeItemFromCraftingPanel(1);

        player.getInventory().showInventory();

        player.getInventory().craftItem();
        player.getInventory().showInventory();

        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 1);
        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 2);
        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 3);
        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 4);
        player.getInventory().showInventory();
        player.getInventory().craftItem();

        player.getInventory().showInventory();

        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Log"), 1);
        player.getInventory().showInventory();
        player.getInventory().craftItem();
        player.getInventory().showInventory();

        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 1);
        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 3);
        player.getInventory().showInventory();
        player.getInventory().craftItem();
        player.getInventory().showInventory();

        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 2);
        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 4);
        player.getInventory().showInventory();
        player.getInventory().craftItem();
        player.getInventory().showInventory();

        player.getInventory().equipItem(player.getInventory().getItemByName("Stick"));
        player.getInventory().showInventory();
        player.getInventory().equipItem(player.getInventory().getItemByName("Crafting Table"));
        player.getInventory().showInventory();
        player.getInventory().unequipItem();
        player.getInventory().showInventory();
        player.getInventory().equipItem(player.getInventory().getItemByName("Oak Planks"));

        for(Player p : playerList){
            System.out.println(p.getName());
            player.getInventory().showInventory();
        }

    }
}