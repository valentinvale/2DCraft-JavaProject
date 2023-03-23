package Player;
import java.util.*;

import Items.Item;

class SortByItemName implements Comparator<Item> {
    public int compare(Item a, Item b) {
        if(a == null || b == null)
            return 0;
        else if(a.getName() == null || b.getName() == null)
            return 0;
        else if(a.getName().equals(b.getName()))
            return 0;
        else if(a.getName().compareTo(b.getName()) > 0)
            return 1;
        else if(a.getName().compareTo(b.getName()) < 0)
            return -1;
        else
            return 0;
    }
}

public class Inventory {
    private Item[] items;
    private int size;
    private Item craftingPanel1;
    private Item craftingPanel2;
    private Item craftingPanel3;
    private Item craftingPanel4;
    private Item craftingResult;
    private int craftingResultAmount;
    private Item equippedItem;

    public Inventory(int size) {
        this.size = size;
        this.items = new Item[size];
        this.craftingPanel1 = null;
        this.craftingPanel2 = null;
        this.craftingPanel3 = null;
        this.craftingPanel4 = null;
        this.craftingResult = null;
        this.craftingResultAmount = 0;
        this.equippedItem = null;
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
        else{
            Arrays.sort(items, new SortByItemName());
        }

    }

    public boolean removeItem(Item item){
        boolean hasItem = false;
        if(item != null)
            for (int i = 0; i < items.length; i++) {
                if(items[i] != null && items[i].getName().equals(item.getName())){
                    for (int j = i + 1; j < items.length; j++) {
                        items[j - 1] = items[j];
                    }
                    items[items.length - 1] = null;
                    hasItem = true;
                    break;
                }
            }
        return hasItem;
    }

    public void showInventory(){
        for (Item item : items) {
            if (item != null) {
                System.out.print(item.getName() + " ");
            }
        }

        System.out.println();
        if(this.craftingPanel1 == null)
            System.out.print("Crafting Panel 1: null | ");
        else
            System.out.print("Crafting Panel 1: " + this.craftingPanel1.getName() + " | ");
        if(this.craftingPanel2 == null)
            System.out.print("Crafting Panel 2: null " + '\n');
        else
            System.out.print("Crafting Panel 2: " + this.craftingPanel2.getName() + '\n');
        if(this.craftingPanel3 == null)
            System.out.print("Crafting Panel 3: null | ");
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

        if(this.equippedItem == null)
            System.out.println("Equipped Item: null" + '\n');
        else
            System.out.println("Equipped Item: " + this.equippedItem.getName() + '\n');

    }

    public Item getItemByName(String name){
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                return item;
            }
        }
        System.out.println("Item not found in inventory!" + '\n');
        return null;

    }

    public void equipItem(Item item){
        if(this.removeItem(item))
        {
            if(this.equippedItem != null)
                this.addItem(this.equippedItem);
            this.equippedItem = item;
        }
    }

    public void unequipItem(){
        if(this.equippedItem != null)
        {
            this.addItem(this.equippedItem);
            this.equippedItem = null;
        }
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
        if(this.removeItem(item))
            switch (panel) {
                case 1 -> {this.craftingPanel1 = item; this.calculateCraftingResult();}
                case 2 -> {this.craftingPanel2 = item; this.calculateCraftingResult();}
                case 3 -> {this.craftingPanel3 = item; this.calculateCraftingResult();}
                case 4 -> {this.craftingPanel4 = item; this.calculateCraftingResult();}
            }

    }

    public void removeItemFromCraftingPanel(int panel){
        switch (panel) {
            case 1 -> {this.addItem(this.craftingPanel1); this.craftingPanel1 = null; this.calculateCraftingResult();}
            case 2 -> {this.addItem(this.craftingPanel2); this.craftingPanel2 = null; this.calculateCraftingResult();}
            case 3 -> {this.addItem(this.craftingPanel3); this.craftingPanel3 = null; this.calculateCraftingResult();}
            case 4 -> {this.addItem(this.craftingPanel4); this.craftingPanel4 = null; this.calculateCraftingResult();}
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
        // reteta 2: 2 planks -> 4 stick
        else if((this.craftingPanel1 != null && this.craftingPanel1.getName().endsWith("Planks") && this.craftingPanel2 == null && this.craftingPanel3 != null && this.craftingPanel3.getName().endsWith("Planks") && this.craftingPanel4 == null) ||
                (this.craftingPanel1 == null && this.craftingPanel2 != null && this.craftingPanel2.getName().endsWith("Planks") && this.craftingPanel3 == null && this.craftingPanel4 != null && this.craftingPanel4.getName().endsWith("Planks")))
        {
            this.craftingResult = new Items.Stick(3, "Stick");
            this.craftingResultAmount = 4;
            ok = true;
        }
        // reteta 3: 4 planks -> 1 Crafting Table
        else if((this.craftingPanel1 != null && this.craftingPanel1.getName().endsWith("Planks") && this.craftingPanel2 != null && this.craftingPanel2.getName().endsWith("Planks") && this.craftingPanel3 != null && this.craftingPanel3.getName().endsWith("Planks") && this.craftingPanel4 != null && this.craftingPanel4.getName().endsWith("Planks")))
        {
            this.craftingResult = new Items.CraftingTable(4, "Crafting Table");
            this.craftingResultAmount = 1;
            ok = true;
        }

        if(!ok)
        {
            this.craftingResult = null;
            this.craftingResultAmount = 0;
        }


    }

}
