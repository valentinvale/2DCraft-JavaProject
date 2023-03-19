package Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Items.Item;

public class Inventory {
    private Item[] items;
    private int size;
    private Item craftingPanel1;
    private Item craftingPanel2;
    private Item craftingPanel3;
    private Item craftingPanel4;
    private Item craftingResult;
    private int craftingResultAmount;

    public Inventory(int size) {
        this.size = size;
        this.items = new Item[size];
        this.craftingPanel1 = null;
        this.craftingPanel2 = null;
        this.craftingPanel3 = null;
        this.craftingPanel4 = null;
        this.craftingResult = null;
        this.craftingResultAmount = 0;
    }

    public int getSize() {
        return size;
    }

    public Item[] getItems() {
        return items;
    }

    public void addItem(Item item) {
        boolean hasSpace = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                hasSpace = true;
                break;
            }
        }

        if (!hasSpace) {
            System.out.println("Inventory is full!");
        }

    }

    public void removeItem(Item item){
        for (int i = 0; i < items.length; i++) {
            if(items[i] != null && Objects.equals(items[i].getName(), item.getName())){
                for(int j = i; j < items.length - 1; j++){
                    items[j] = items[j + 1];
                }
                items[items.length - 1] = null;
            }
        }
    }

    public void showInventory(){
        for (Item item : items) {
            if (item != null) {
                System.out.print(item.getName() + " ");
            }
        }

        System.out.println();
        if(this.craftingPanel1 == null)
            System.out.print("Crafting Panel 1: null ");
        else
            System.out.print("Crafting Panel 1: " + this.craftingPanel1.getName() + " | ");
        if(this.craftingPanel2 == null)
            System.out.print("Crafting Panel 2: null " + '\n');
        else
            System.out.print("Crafting Panel 2: " + this.craftingPanel2.getName() + '\n');
        if(this.craftingPanel3 == null)
            System.out.print("Crafting Panel 3: null ");
        else
            System.out.print("Crafting Panel 3: " + this.craftingPanel3.getName() + " | ");
        if(this.craftingPanel4 == null)
            System.out.print("Crafting Panel 4: null " + '\n');
        else
            System.out.print("Crafting Panel 4: " + this.craftingPanel4.getName() + '\n');

        if(this.craftingResult == null)
            System.out.println("Crafting Result: null ");
        else
            System.out.println("Crafting Result: " + this.craftingResult.getName() + " x" + this.craftingResultAmount);

    }

    public void craftItem(){
        if(this.craftingResult != null){
            for(int i = 0; i < this.craftingResultAmount; i++)
                this.addItem(this.craftingResult);
            this.craftingPanel1 = null;
            this.craftingPanel2 = null;
            this.craftingPanel3 = null;
            this.craftingPanel4 = null;
            this.craftingResult = null;
        }
    }

    public void addItemToCraftingPanel(Item item, int panel){
        switch (panel) {
            case 1 -> {this.craftingPanel1 = item; calculateCraftingResult();}
            case 2 -> {this.craftingPanel2 = item; calculateCraftingResult();}
            case 3 -> {this.craftingPanel3 = item; calculateCraftingResult();}
            case 4 -> {this.craftingPanel4 = item; calculateCraftingResult();}
        }
        removeItem(item);

    }

    public void removeItemFromCraftingPanel(int panel){
        switch (panel) {
            case 1 -> {addItem(this.craftingPanel1); this.craftingPanel1 = null; calculateCraftingResult();}
            case 2 -> {addItem(this.craftingPanel2); this.craftingPanel2 = null; calculateCraftingResult();}
            case 3 -> {addItem(this.craftingPanel3); this.craftingPanel3 = null; calculateCraftingResult();}
            case 4 -> {addItem(this.craftingPanel4); this.craftingPanel4 = null; calculateCraftingResult();}
        }
    }

    public void calculateCraftingResult()
    {
        boolean ok = false; // daca s-a gasit o reteta
        // retetele
        // reteta 1: 1 log -> 4 planks
        if((this.craftingPanel1 != null && this.craftingPanel1.getName().endsWith("Log") && this.craftingPanel2 == null && this.craftingPanel3 == null && this.craftingPanel4 == null) ||
            (this.craftingPanel2 != null && this.craftingPanel2.getName().endsWith("Log") && this.craftingPanel1 == null && this.craftingPanel3 == null && this.craftingPanel4 == null) ||
            (this.craftingPanel3 != null && this.craftingPanel3.getName().endsWith("Log") && this.craftingPanel1 == null && this.craftingPanel2 == null && this.craftingPanel4 == null) ||
            (this.craftingPanel4 != null && this.craftingPanel4.getName().endsWith("Log") && this.craftingPanel1 == null && this.craftingPanel2 == null && this.craftingPanel3 == null))
        {
            ok = true;
            if(this.craftingPanel1 != null)
            {
                this.craftingResult = new Items.Planks(2, this.craftingPanel1.getName().substring(0, this.craftingPanel1.getName().indexOf(" ")) + " Planks");
            }
            else if(this.craftingPanel2 != null)
            {
                this.craftingResult = new Items.Planks(2, this.craftingPanel2.getName().substring(0, this.craftingPanel2.getName().indexOf(" ")) + " Planks");
            }
            else if(this.craftingPanel3 != null)
            {
                this.craftingResult = new Items.Planks(2, this.craftingPanel3.getName().substring(0, this.craftingPanel3.getName().indexOf(" ")) + " Planks");
            }
            else if(this.craftingPanel4 != null)
            {
                this.craftingResult = new Items.Planks(2, this.craftingPanel4.getName().substring(0, this.craftingPanel4.getName().indexOf(" ")) + " Planks");
            }
            this.craftingResultAmount = 4;
        }

        if(!ok)
        {
            this.craftingResult = null;
            this.craftingResultAmount = 0;
        }


    }

}
