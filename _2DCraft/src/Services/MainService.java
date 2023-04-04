package Services;

import Blocks.Block;
import Player.Player;
import Player.Inventory;
import Player.RecipeBook;

import java.util.ArrayList;
import java.util.Arrays;

public class MainService {
    private static ArrayList<Player> playerList;
    private static int currentPlayerIndex;
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

    private static ArrayList<Block> existingBlocksList;

    public MainService() {
        playerList = new ArrayList<Player>();
        existingBlocksList = new ArrayList<Block>(); // aici voi adauga blocurile existente in lume la inceputul jocului, unele o sa fie random
        currentPlayerIndex = 0;
    }

    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }
    public static void addNewPlayer(String name) {
        Player player = new Player(name, 100, new Inventory(200), new RecipeBook());
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
            System.out.println(index + ". " + block.getName());
        }
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

    public static void unequipItem(int indexItem){
        getCurrentPlayer().getInventory().unequipItem();
    }

    public static void breakBlock(int indexBlock){
        existingBlocksList.get(indexBlock).breakBlock(getCurrentPlayer());
        existingBlocksList.remove(indexBlock);
    }

    public static void useItem(int indexItem){
        getCurrentPlayer().getInventory().getItems().get(indexItem).useItem();
    }

}
