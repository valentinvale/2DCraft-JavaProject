package Player;
import java.util.*;

import Items.Item;

//class SortByItemName implements Comparator<Item> {
//    public int compare(Item a, Item b) {
//        if(a == null || b == null)
//            return 0;
//        else if(a.getName() == null || b.getName() == null)
//            return 0;
//        else if(a.getName().equals(b.getName()))
//            return 0;
//        else if(a.getName().compareTo(b.getName()) > 0)
//            return 1;
//        else if(a.getName().compareTo(b.getName()) < 0)
//            return -1;
//        else
//            return 0;
//    }
//}

public class Inventory {
    private int id;
    private List<Item> items;
    private int size;
    private Item craftingPanel1;
    private Item craftingPanel2;
    private Item craftingPanel3;
    private Item craftingPanel4;
    private Item craftingResult;
    private int craftingResultAmount;
    private Item equippedItem;

    public Inventory(int id, int size) {
        this.id = id;
        this.size = size;
        this.items = new ArrayList<Item>();
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

    public List<Item> getItems() {
        return items;
    }

    public Item getEquippedItem() {
        return equippedItem;
    }
    public void setEquippedItem(Item equippedItem) {
        this.equippedItem = equippedItem;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        boolean hasSpace = true;
        //System.out.println(this.items.size() + " " + this.size);
        if(this.items.size() == this.size){
            hasSpace = false;
        }
        else
            this.items.add(item);

        if (!hasSpace) {
            System.out.println("Inventory is full!");
        }
        else{
            Collections.sort(this.items);
        }

    }
    public boolean checkIfItemExists(int id){
        boolean exists = false;
        for (Item item : items) {
            if(item != null && item.getId() == id){
                exists = true;
                break;
            }
        }
        return exists;
    }
    public boolean removeItem(Item item){
        boolean hasItem = false;
        if(item != null)
            for (int i = 0; i < items.size(); i++) {
                if(items.get(i) != null && items.get(i).getId() == item.getId()){
                    items.remove(i);
                    hasItem = true;
                    break;
                }
            }
        return hasItem;
    }

    public void showInventory(){
        int index = 0;
        System.out.print("Items: ");
        for (Item item : items) {
            if (item != null) {
                index++;
                System.out.print(index + ". " + item.getName() + " ");
            }
        }

        System.out.println();
        if(this.craftingPanel1 == null)
            System.out.print("Crafting Panel 1: Empty | ");
        else
            System.out.print("Crafting Panel 1: " + this.craftingPanel1.getName() + " | ");
        if(this.craftingPanel2 == null)
            System.out.print("Crafting Panel 2: Empty " + '\n');
        else
            System.out.print("Crafting Panel 2: " + this.craftingPanel2.getName() + '\n');
        if(this.craftingPanel3 == null)
            System.out.print("Crafting Panel 3: Empty | ");
        else
            System.out.print("Crafting Panel 3: " + this.craftingPanel3.getName() + " | ");
        if(this.craftingPanel4 == null)
            System.out.print("Crafting Panel 4: Empty " + '\n');
        else
            System.out.print("Crafting Panel 4: " + this.craftingPanel4.getName() + '\n');

        if(this.craftingResult == null)
            System.out.println("Crafting Result: Empty ");
        else
            System.out.println("Crafting Result: " + this.craftingResult.getName() + " x" + this.craftingResultAmount);

        if(this.equippedItem == null)
            System.out.println("Equipped Item: Empty" + '\n');
        else
            System.out.println("Equipped Item: " + this.equippedItem.getName() + '\n');

    }

    public List<Item> getCraftingPanels(){
        List<Item> craftingPanels = new ArrayList<Item>();
        craftingPanels.add(this.craftingPanel1);
        craftingPanels.add(this.craftingPanel2);
        craftingPanels.add(this.craftingPanel3);
        craftingPanels.add(this.craftingPanel4);
        return craftingPanels;
    }

    public Item getCraftingResult(){
        return this.craftingResult;
    }

    public void closeInventory(){
        if(this.craftingPanel1 != null)
            this.removeItemFromCraftingPanel(1);
        if(this.craftingPanel2 != null)
            this.removeItemFromCraftingPanel(2);
        if(this.craftingPanel3 != null)
            this.removeItemFromCraftingPanel(3);
        if(this.craftingPanel4 != null)
            this.removeItemFromCraftingPanel(4);
        if(this.craftingResult != null)
            this.removeItemFromCraftingPanel(5);
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

    public int getId() {
        return id;
    }

    public int getCraftingResultAmount() {
        return craftingResultAmount;
    }

    public void equipItem(Item item){
        if(this.removeItem(item))
        {
            if(this.equippedItem != null)
                this.addItem(this.equippedItem);
            this.equippedItem = item;
        }
    }

    public boolean unequipItem(){
        if(this.equippedItem != null)
        {
            this.addItem(this.equippedItem);
            this.equippedItem = null;
            return true;
        }
        return false;
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
                case 1 -> {
                    if(this.craftingPanel1 != null)
                        this.addItem(this.craftingPanel1);
                    this.craftingPanel1 = item;
                    this.calculateCraftingResult();
                }
                case 2 -> {
                    if(this.craftingPanel2 != null)
                        this.addItem(this.craftingPanel2);
                    this.craftingPanel2 = item;
                    this.calculateCraftingResult();
                }
                case 3 -> {
                    if(this.craftingPanel3 != null)
                        this.addItem(this.craftingPanel3);
                    this.craftingPanel3 = item;
                    this.calculateCraftingResult();
                }
                case 4 -> {
                    if(this.craftingPanel4 != null)
                        this.addItem(this.craftingPanel4);
                    this.craftingPanel4 = item;
                    this.calculateCraftingResult();
                }
            }

    }

    public void removeItemFromCraftingPanel(int panel){
        switch (panel) {
            case 1 -> {
                if(this.craftingPanel1 != null)
                    this.addItem(this.craftingPanel1);
                this.craftingPanel1 = null;
                this.calculateCraftingResult();
            }
            case 2 -> {
                if(this.craftingPanel2 != null)
                    this.addItem(this.craftingPanel2);
                this.craftingPanel2 = null;
                this.calculateCraftingResult();
            }
            case 3 -> {
                if(this.craftingPanel3 != null)
                    this.addItem(this.craftingPanel3);
                this.craftingPanel3 = null;
                this.calculateCraftingResult();
            }
            case 4 -> {
                if(this.craftingPanel4 != null)
                    this.addItem(this.craftingPanel4);
                this.craftingPanel4 = null;
                this.calculateCraftingResult();
            }
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
                this.craftingResult = new Items.Planks(0, this.craftingPanel1.getName().substring(0, this.craftingPanel1.getName().lastIndexOf(" ")) + " Planks");
            }
            else if(this.craftingPanel2 != null)
            {
                this.craftingResult = new Items.Planks(0, this.craftingPanel2.getName().substring(0, this.craftingPanel2.getName().lastIndexOf(" ")) + " Planks");
            }
            else if(this.craftingPanel3 != null)
            {
                this.craftingResult = new Items.Planks(0, this.craftingPanel3.getName().substring(0, this.craftingPanel3.getName().lastIndexOf(" ")) + " Planks");
            }
            else if(this.craftingPanel4 != null)
            {
                this.craftingResult = new Items.Planks(0, this.craftingPanel4.getName().substring(0, this.craftingPanel4.getName().lastIndexOf(" ")) + " Planks");
            }
            this.craftingResultAmount = 4;
        }
        // reteta 2: 2 planks -> 4 stick
        else if((this.craftingPanel1 != null && this.craftingPanel1.getName().endsWith("Planks") && this.craftingPanel2 == null && this.craftingPanel3 != null && this.craftingPanel3.getName().endsWith("Planks") && this.craftingPanel4 == null) ||
                (this.craftingPanel1 == null && this.craftingPanel2 != null && this.craftingPanel2.getName().endsWith("Planks") && this.craftingPanel3 == null && this.craftingPanel4 != null && this.craftingPanel4.getName().endsWith("Planks")))
        {
            this.craftingResult = new Items.Stick(0, "Stick");
            this.craftingResultAmount = 4;
            ok = true;
        }
        // reteta 3: 4 planks -> 1 Crafting Table
        else if((this.craftingPanel1 != null && this.craftingPanel1.getName().endsWith("Planks") && this.craftingPanel2 != null && this.craftingPanel2.getName().endsWith("Planks") && this.craftingPanel3 != null && this.craftingPanel3.getName().endsWith("Planks") && this.craftingPanel4 != null && this.craftingPanel4.getName().endsWith("Planks")))
        {
            this.craftingResult = new Items.CraftingTable(0, "Crafting Table");
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
