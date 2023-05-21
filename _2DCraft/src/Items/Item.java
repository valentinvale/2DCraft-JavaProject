package Items;

public abstract class Item implements Comparable<Item>{
    protected int id = 0;
    protected String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void useItem();

    @Override
    public int compareTo(Item o) {

        if(this.getName().compareTo(o.getName()) > 0) {
            return 1;
        } else if(this.getName().compareTo(o.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}
