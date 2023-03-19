package Blocks;

import Items.Item;

public class CraftingTable extends Block{
    private Item craftinPanel1;
    private Item craftinPanel2;
    private Item craftinPanel3;
    private Item craftinPanel4;
    private Item craftinPanel5;
    private Item craftinPanel6;
    private Item craftinPanel7;
    private Item craftinPanel8;
    private Item craftinPanel9;
    public CraftingTable(int id, String name, double durability, String texture, double x, double y) {
        super(id, name, durability, texture, x, y);
        this.craftinPanel1 = null;
        this.craftinPanel2 = null;
        this.craftinPanel3 = null;
        this.craftinPanel4 = null;
        this.craftinPanel5 = null;
        this.craftinPanel6 = null;
        this.craftinPanel7 = null;
        this.craftinPanel8 = null;
        this.craftinPanel9 = null;
    }

    @Override
    public void dropItem(Player.Player player) {
        player.getInventory().addItem(new Items.CraftingTable(4, "Crafting Table"));
    }

    public void calculateCraftingResult(){
        // to be implemented
    }

    public void addItemToCraftingPanel(Player.Player player, Item item, int panel){
        switch (panel) {
            case 1 -> {this.craftinPanel1 = item; calculateCraftingResult();}
            case 2 -> {this.craftinPanel2 = item; calculateCraftingResult();}
            case 3 -> {this.craftinPanel3 = item; calculateCraftingResult();}
            case 4 -> {this.craftinPanel4 = item; calculateCraftingResult();}
            case 5 -> {this.craftinPanel5 = item; calculateCraftingResult();}
            case 6 -> {this.craftinPanel6 = item; calculateCraftingResult();}
            case 7 -> {this.craftinPanel7 = item; calculateCraftingResult();}
            case 8 -> {this.craftinPanel8 = item; calculateCraftingResult();}
            case 9 -> {this.craftinPanel9 = item; calculateCraftingResult();}
        }
        player.getInventory().removeItem(item);
    }

    public void removeItemFromCraftingPanel(Player.Player player, int panel){
        switch (panel) {
            case 1 -> {player.getInventory().addItem(this.craftinPanel1); this.craftinPanel1 = null; calculateCraftingResult();}
            case 2 -> {player.getInventory().addItem(this.craftinPanel2); this.craftinPanel2 = null; calculateCraftingResult();}
            case 3 -> {player.getInventory().addItem(this.craftinPanel3); this.craftinPanel3 = null; calculateCraftingResult();}
            case 4 -> {player.getInventory().addItem(this.craftinPanel4); this.craftinPanel4 = null; calculateCraftingResult();}
            case 5 -> {player.getInventory().addItem(this.craftinPanel5); this.craftinPanel5 = null; calculateCraftingResult();}
            case 6 -> {player.getInventory().addItem(this.craftinPanel6); this.craftinPanel6 = null; calculateCraftingResult();}
            case 7 -> {player.getInventory().addItem(this.craftinPanel7); this.craftinPanel7 = null; calculateCraftingResult();}
            case 8 -> {player.getInventory().addItem(this.craftinPanel8); this.craftinPanel8 = null; calculateCraftingResult();}
            case 9 -> {player.getInventory().addItem(this.craftinPanel9); this.craftinPanel9 = null; calculateCraftingResult();}

        }
    }

}
