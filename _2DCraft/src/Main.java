import Blocks.*;
import Player.*;
import Items.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Player> playerList = new HashSet<>();

        Inventory inventory = new Inventory(20);
        RecipeBook recipeBook = new RecipeBook();
        Recipe oakPlanksRecipe = new Recipe("Oak Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(1, "Oak Log"))), new Items.Planks(2, "Oak Planks"), 4);
        Recipe craftingTableRecipe = new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Oak Planks"), new Items.Planks(2, "Oak Planks"), null, new Items.Planks(2, "Oak Planks"), new Items.Planks(2, "Oak Planks"))), new Items.CraftingTable(4, "Crafting Table"), 1);
        Recipe stickRecipe = new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Oak Planks"), null, null, new Items.Planks(2, "Oak Planks"))), new Items.Stick(3, "Stick"), 4);

        recipeBook.addRecipe(oakPlanksRecipe);
        recipeBook.addRecipe(craftingTableRecipe);
        recipeBook.addRecipe(stickRecipe);

        System.out.println(inventory.getItems().size());
        Player player = new Player("Player", 100, inventory, recipeBook);
        playerList.add(player);

        player.getRecipeBook().openRecipeBook(player);

        Block OakLeavesBlock = new Blocks.Leaves(0, "Oak Leaves", 100, "Oak.png", 0, 0);
        Block OakLogBlock = new Blocks.Log(1, "Oak Log", 100, "Oak.png", 0, 0);
        System.out.println(player.getInventory().getItems().size());
        OakLeavesBlock.dropItem(player);
        OakLogBlock.dropItem(player);
        OakLogBlock.dropItem(player);
        OakLogBlock.dropItem(player);
        OakLogBlock.dropItem(player);
        //System.out.println(player.getInventory().getItems().size());
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

        player.getRecipeBook().openRecipeBook(player);

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

        player.getRecipeBook().openRecipeBook(player);

        for(Player p : playerList){
            System.out.println(p.getName());
            player.getInventory().showInventory();
        }

    }
}