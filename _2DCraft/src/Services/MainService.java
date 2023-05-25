package Services;

import Blocks.Block;
import DataBase.*;
import Items.Item;
import Player.Player;
import Player.Inventory;
import Player.RecipeBook;
import Player.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainService {

    private static PlayerDatabase playerDatabase = new PlayerDatabase();
    private static InventoryDatabase inventoryDatabase = new InventoryDatabase();
    private static ItemDatabase itemDatabase = new ItemDatabase();

    private static RecipebookDatabase recipebookDatabase = new RecipebookDatabase();
    private static int maxPlayerId = playerDatabase.getMaxId();
    private static int maxInventoryId = inventoryDatabase.getMaxId();
    private static List<Player> playerList = new ArrayList<Player>();
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
            new Recipe("Oak Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(0, "Oak Log"))), new Items.Planks(0, "Oak Planks"), 4),
            new Recipe("Spruce Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(0, "Spruce Log"))), new Items.Planks(0, "Spruce Planks"), 4),
            new Recipe("Birch Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(0, "Birch Log"))), new Items.Planks(0, "Birch Planks"), 4),
            new Recipe("Jungle Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(0, "Jungle Log"))), new Items.Planks(0, "Jungle Planks"), 4),
            new Recipe("Acacia Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(0, "Acacia Log"))), new Items.Planks(0, "Acacia Planks"), 4),
            new Recipe("Dark Oak Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(0, "Dark Oak Log"))), new Items.Planks(0, "Dark Oak Planks"), 4),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Oak Planks"), new Items.Planks(0, "Oak Planks"), null, new Items.Planks(0, "Oak Planks"), new Items.Planks(0, "Oak Planks"))), new Items.CraftingTable(0, "Crafting Table"), 1),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Spruce Planks"), new Items.Planks(0, "Spruce Planks"), null, new Items.Planks(0, "Spruce Planks"), new Items.Planks(0, "Spruce Planks"))), new Items.CraftingTable(0, "Crafting Table"), 1),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Birch Planks"), new Items.Planks(0, "Birch Planks"), null, new Items.Planks(0, "Birch Planks"), new Items.Planks(0, "Birch Planks"))), new Items.CraftingTable(0, "Crafting Table"), 1),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Jungle Planks"), new Items.Planks(0, "Jungle Planks"), null, new Items.Planks(0, "Jungle Planks"), new Items.Planks(0, "Jungle Planks"))), new Items.CraftingTable(0, "Crafting Table"), 1),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Acacia Planks"), new Items.Planks(0, "Acacia Planks"), null, new Items.Planks(0, "Acacia Planks"), new Items.Planks(0, "Acacia Planks"))), new Items.CraftingTable(0, "Crafting Table"), 1),
            new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Dark Oak Planks"), new Items.Planks(0, "Dark Oak Planks"), null, new Items.Planks(0, "Dark Oak Planks"), new Items.Planks(0, "Dark Oak Planks"))), new Items.CraftingTable(0, "Crafting Table"), 1),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Oak Planks"), null, null, new Items.Planks(0, "Oak Planks"))), new Items.Stick(0, "Stick"), 4),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Spruce Planks"), null, null, new Items.Planks(0, "Spruce Planks"))), new Items.Stick(0, "Stick"), 4),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Birch Planks"), null, null, new Items.Planks(0, "Birch Planks"))), new Items.Stick(0, "Stick"), 4),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Jungle Planks"), null, null, new Items.Planks(0, "Jungle Planks"))), new Items.Stick(0, "Stick"), 4),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Acacia Planks"), null, null, new Items.Planks(0, "Acacia Planks"))), new Items.Stick(0, "Stick"), 4),
            new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(0, "Dark Oak Planks"), null, null, new Items.Planks(0, "Dark Oak Planks"))), new Items.Stick(0, "Stick"), 4)
    ));

    private static List<Block> existingBlocksList = new ArrayList<Block>();

    public static List<Player> getPlayerList() {
        return playerList;
    }

    public static List<Recipe> getRecipeList() {
        return recipeList;
    }

    public static boolean checkIfBlockExistsInExistingBlockList(int id){
        for(Block block : existingBlocksList){
            if(block.getId() == id)
                return true;
        }
        return false;
    }

    public static void loadGame(){
        PlayerDatabase playerDatabase = new PlayerDatabase();
        playerList = playerDatabase.getAllPlayers();
        BlockDatabase blockDatabase = new BlockDatabase();
        existingBlocksList = blockDatabase.getAllBlocks();
    }

    public static void saveGame(){
        PlayerDatabase playerDatabase = new PlayerDatabase();
        InventoryDatabase inventoryDatabase = new InventoryDatabase();
        ItemDatabase itemDatabase = new ItemDatabase();
        BlockDatabase blockDatabase = new BlockDatabase();

        for(Block block : existingBlocksList){
            if(!blockDatabase.checkIfBlockExists(block.getId())){
                blockDatabase.addBlock(block.getName());
            }
        }

        List<Block> databaseBlocks = blockDatabase.getAllBlocks();

        for(Block block : databaseBlocks){
            if(!MainService.checkIfBlockExistsInExistingBlockList(block.getId())){
                blockDatabase.removeBlock(block.getId());
            }
        }

        for(Player player : playerList){
            if(!playerDatabase.checkIfPlayerExists(player.getId())){
                playerDatabase.addPlayer(player.getName(), player.getHealth());
                //System.out.println("id player" + player.getId());
                inventoryDatabase.addInventory(player.getId());
                for(Item item : player.getInventory().getItems()){
                    //System.out.println("id inventar" + player.getInventory().getId());
                    itemDatabase.addItem(item.getName(), player.getInventory().getId());
                }
                String rbUnlockString = "";
                for(Recipe recipe : player.getRecipeBook().getRecipes()){
                    if(recipe.getUnlocked())
                        rbUnlockString += "1";
                    else
                        rbUnlockString += "0";
                }
                recipebookDatabase.addRecipebook(rbUnlockString, player.getId());
            }
            else{
                List<Item> databaseItems = itemDatabase.getItemsByInventoryId(player.getInventory().getId());
                for(Item item : databaseItems){
                    if(!player.getInventory().checkIfItemExists(item.getId())){
                        itemDatabase.removeItem(item.getId());
                    }
                }
                for(Item item : player.getInventory().getItems()){
                    if(!itemDatabase.checkIfItemExists(item.getId())){
                        itemDatabase.addItem(item.getName(), player.getInventory().getId());
                    }
                }
                String currentUnlockString = recipebookDatabase.getUnlockstring(player.getId());
                for(int i = 0; i < player.getRecipeBook().getRecipes().size(); i++){
                    if(player.getRecipeBook().getRecipes().get(i).getUnlocked() && currentUnlockString.charAt(i) == '0'){
                        recipebookDatabase.updateUnlockString(player.getId(), i);
                    }
                }

            }
        }
    }

    public static void addNewPlayer(String name) {
        maxPlayerId++;
        maxInventoryId++;
        Player player = new Player(maxPlayerId, name, 100, new Inventory(maxInventoryId, 200));
        for(Recipe recipe : recipeList){
            Recipe aux = new Recipe(recipe);
            player.getRecipeBook().addRecipe(aux);
        }
        playerList.add(player);
    }

    public static void removePlayer(int index) {
        if(playerDatabase.checkIfPlayerExists(playerList.get(index).getId())){
            for(Item item : playerList.get(index).getInventory().getItems()){
                if(itemDatabase.checkIfItemExists(item.getId())){
                    //System.out.println("id item" + item.getId());
                    itemDatabase.removeItem(item.getId());
                }
            }
            //System.out.println("id inventar" + playerList.get(index).getInventory().getId());
            inventoryDatabase.removeInventory(playerList.get(index).getInventory().getId());
            //System.out.println("id player" + playerList.get(index).getId());
            playerDatabase.removePlayer(playerList.get(index).getId());
        }
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

    public static List<Block> getExistingBlocksList() {
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
