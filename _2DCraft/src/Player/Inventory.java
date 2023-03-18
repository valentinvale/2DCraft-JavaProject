package Player;
import java.util.ArrayList;
import java.util.List;
import Items.Item;

public class Inventory {
    public Item[] items;
    public int size;

    public Inventory(int size) {
        this.size = size;
        items = new Item[size];
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

    public void showInventory(){
        for (int i = 0; i < items.length; i++) {
            if(items[i] != null){
                System.out.println(items[i].getName());
            }
        }
    }

}
