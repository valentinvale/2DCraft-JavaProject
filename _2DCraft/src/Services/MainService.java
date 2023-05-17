package Services;

import Blocks.Block;
import Items.Item;
import Player.Player;
import Player.Inventory;
import Player.RecipeBook;
import Player.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainService {
    private static ArrayList<Player> playerList = new ArrayList<Player>();
    private static int currentPlayerIndex = 0;
    private static final ArrayList<Block> blockList = new ArrayList<Block>(Arrays.asList(
            new Blocks.Log(0, "Oak Log", 100, "Oak.png", 0, 0),
            new Blocks.Log(1, "Birch Log", 100, "Birch.png", 0, 0),
            new Blocks.Log(2, "Spruce Log", 100, "Spruce.png", 0, 0),
            new Blocks.Log(3, "Jungle Log", 100, "Jungle.png", 0, 0),
            new Blocks.Log(4, "Acacia Log", 100, "Acacia.png", 0, 0),
            new Blocks.Log(5, "Dark Oak Log", 100, "DarkOak.png", 0, 0),
            new Blocks.Leaves(6, "Oak Leaves", 100, "Oak.png", 0, 0),
            new Blocks.Leaves(7, "Birch Leaves", 100, "Birch.png", 0, 0),
            new Blocks.Leaves(8, "Spruce Leaves", 100, "Spruce.png", 0, 0),
            new Blocks.Leaves(9, "Jungle Leaves", 100, "Jungle.png", 0, 0),
            new Blocks.Leaves(10, "Acacia Leaves", 100, "Acacia.png", 0, 0),
            new Blocks.Leaves(11, "Dark Oak Leaves", 100, "DarkOak.png", 0, 0)
    ));

    private static final ArrayList<Recipe>  recipeList = new ArrayList<Recipe>(Arrays.asList(
            new Recipe("Oak Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(1, "Oak Log"))), new Items.Planks(2, "Oak Planks"), 4),
            new Recipe("Spruce Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(1, "Spruce Log"))), new Items.Planks(2, "Spruce Planks"), 4),
            new Recipe("Birch Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(1, "Birch Log"))), new Items.Planks(2, "Birch Planks"), 4),
            new Recipe("Jungle Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(1, "Jungle Log"))), new Items.Planks(2, "Jungle Planks"), 4),
            new Recipe("Acacia Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(1, "Acacia Log"))), new Items.Planks(2, "Acacia Planks"), 4),
            new Recipe("Dark Oak Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(1, "Dark Oak Log"))), new Items.Planks(2, "Dark Oak Planks"), 4),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Oak Planks"), new Items.Planks(2, "Oak Planks"), null, new Items.Planks(2, "Oak Planks"), new Items.Planks(2, "Oak Planks"))), new Items.CraftingTable(4, "Crafting Table"), 1),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Spruce Planks"), new Items.Planks(2, "Spruce Planks"), null, new Items.Planks(2, "Spruce Planks"), new Items.Planks(2, "Spruce Planks"))), new Items.CraftingTable(4, "Crafting Table"), 1),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Birch Planks"), new Items.Planks(2, "Birch Planks"), null, new Items.Planks(2, "Birch Planks"), new Items.Planks(2, "Birch Planks"))), new Items.CraftingTable(4, "Crafting Table"), 1),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Jungle Planks"), new Items.Planks(2, "Jungle Planks"), null, new Items.Planks(2, "Jungle Planks"), new Items.Planks(2, "Jungle Planks"))), new Items.CraftingTable(4, "Crafting Table"), 1),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Acacia Planks"), new Items.Planks(2, "Acacia Planks"), null, new Items.Planks(2, "Acacia Planks"), new Items.Planks(2, "Acacia Planks"))), new Items.CraftingTable(4, "Crafting Table"), 1),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Dark Oak Planks"), new Items.Planks(2, "Dark Oak Planks"), null, new Items.Planks(2, "Dark Oak Planks"), new Items.Planks(2, "Dark Oak Planks"))), new Items.CraftingTable(4, "Crafting Table"), 1),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Oak Planks"), null, null, new Items.Planks(2, "Oak Planks"))), new Items.Stick(3, "Stick"), 4),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Spruce Planks"), null, null, new Items.Planks(2, "Spruce Planks"))), new Items.Stick(3, "Stick"), 4),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Birch Planks"), null, null, new Items.Planks(2, "Birch Planks"))), new Items.Stick(3, "Stick"), 4),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Jungle Planks"), null, null, new Items.Planks(2, "Jungle Planks"))), new Items.Stick(3, "Stick"), 4),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Acacia Planks"), null, null, new Items.Planks(2, "Acacia Planks"))), new Items.Stick(3, "Stick"), 4),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Dark Oak Planks"), null, null, new Items.Planks(2, "Dark Oak Planks"))), new Items.Stick(3, "Stick"), 4)
    ));

    private static ArrayList<Block> existingBlocksList = new ArrayList<Block>();

    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }
    public static void addNewPlayer(String name) {
        Player player = new Player(name, 100, new Inventory(200));
        for(Recipe recipe : recipeList){
            Recipe aux = new Recipe(recipe);
            player.getRecipeBook().addRecipe(aux);
        }
        playerList.add(player);
    }

    public static void removePlayer(int index) {
        playerList.remove(index);
    }

    public static void showPlayerList() {
        int index = 0;
        for (Player player : playerList) {
            index++;
            System.out.println(index + ". " + player.getName());
        }
    }

    public static void showExistingBlocksList() {
        int index = 0;
        for (Block block : existingBlocksList) {
            index++;
            System.out.print(index + ". " + block.getName() + " ");
        }
        System.out.println();
    }

    public static void choosePlayer(int index) {
        if(index > 0 && index <= playerList.size())
            currentPlayerIndex = index - 1;
        else
            System.out.println("Nu exista un jucator cu acest index!");
    }

    public static Player getCurrentPlayer() {
        return playerList.get(currentPlayerIndex);
    }

    public static ArrayList<Block> getExistingBlocksList() {
        return existingBlocksList;
    }

    public static void openInventory() {
        getCurrentPlayer().getInventory().showInventory();
    }

    public static void closeInventory() {
        getCurrentPlayer().getInventory().closeInventory();
    }

    public static void openRecipeBook() {
        getCurrentPlayer().getRecipeBook().openRecipeBook(getCurrentPlayer());
    }

    public static void addItemToCraftingPanel(int indexItem, int nrCraftingPanel){
        getCurrentPlayer().getInventory().addItemToCraftingPanel(getCurrentPlayer().getInventory().getItems().get(indexItem), nrCraftingPanel);
    }

    public static void removeItemFromCraftingPanel(int nrCraftingPanel){
        getCurrentPlayer().getInventory().removeItemFromCraftingPanel(nrCraftingPanel);
    }

    public static void craftItem(){
        getCurrentPlayer().getInventory().craftItem();
    }

    public static void equipItem(int indexItem){
        getCurrentPlayer().getInventory().equipItem(getCurrentPlayer().getInventory().getItems().get(indexItem));
    }

    public static boolean unequipItem(){
        return getCurrentPlayer().getInventory().unequipItem();
    }

    public static void removeItem(int indexItem){
        getCurrentPlayer().getInventory().removeItem(getCurrentPlayer().getInventory().getItems().get(indexItem));
    }

    public static void generateRandomBlocks(int numberOfBlocks){
        for(int i = 0; i < numberOfBlocks; i++){
            int randomIndex = (int)(Math.random() * blockList.size());
            existingBlocksList.add(blockList.get(randomIndex));
        }
    }

    public static void generateOneRandomBlock(){
        int randomIndex = (int)(Math.random() * blockList.size());
        existingBlocksList.add(blockList.get(randomIndex));
    }

    public static void breakBlock(int indexBlock){
        existingBlocksList.get(indexBlock).breakBlock(getCurrentPlayer());
        existingBlocksList.remove(indexBlock);
    }

    public static void useItem(){
        if(getCurrentPlayer().getInventory().getEquippedItem() != null)
            getCurrentPlayer().getInventory().getEquippedItem().useItem();
        else
            System.out.println("Nu ai niciun item echipat!");
    }



}
