package Player;
import Items.Item;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<Item> craftingPanels = new ArrayList<Item>();
    private Item result;
    private int resultAmount;
    private boolean unlocked;

    public Recipe(String name, ArrayList<Item> craftingPanels, Item result, int resultAmount) {
        this.name = name;
        this.craftingPanels = craftingPanels;
        ArrayList<Item> list = new ArrayList<>(craftingPanels);
        while(list.size() < 9) {
            list.add(null);
        }
        this.craftingPanels = list;

        this.result = result;
        this.resultAmount = resultAmount;
        this.unlocked = false;
    }

    public boolean getUnlocked() {
        return unlocked;
    }

    public ArrayList<Item> getCraftingPanels() {
        return craftingPanels;
    }

    public void unlock() {
        this.unlocked = true;
    }

    public void printRecipe(){
        if(this.craftingPanels.get(0) != null)
            System.out.print(this.craftingPanels.get(0).getName() + " | ");
        else
            System.out.print("Empty | ");
        if(this.craftingPanels.get(1) != null)
            System.out.print(this.craftingPanels.get(1).getName() + " | ");
        else
            System.out.print("Empty | ");
        if(this.craftingPanels.get(2) != null)
            System.out.print(this.craftingPanels.get(2).getName() + '\n');
        else
            System.out.print("Empty " + '\n');
        if(this.craftingPanels.get(3) != null)
            System.out.print(this.craftingPanels.get(3).getName() + " | ");
        else
            System.out.print("Empty | ");
        if(this.craftingPanels.get(4) != null)
            System.out.print(this.craftingPanels.get(4).getName() + " | ");
        else
            System.out.print("Empty | ");
        if(this.craftingPanels.get(5) != null)
            System.out.print(this.craftingPanels.get(5).getName() + " => " + this.resultAmount + "x " + this.result.getName() + '\n');
        else
            System.out.print("Empty " + " => " + this.resultAmount + "x " + this.result.getName() + '\n');
        if(this.craftingPanels.get(6) != null)
            System.out.print(this.craftingPanels.get(6).getName() + " | ");
        else
            System.out.print("Empty | ");
        if(this.craftingPanels.get(7) != null)
            System.out.print(this.craftingPanels.get(7).getName() + " | ");
        else
            System.out.print("Empty | ");
        if(this.craftingPanels.get(8) != null)
            System.out.print(this.craftingPanels.get(8).getName() + '\n');
        else
            System.out.print("Empty " + '\n');
        System.out.println();
    }

}
