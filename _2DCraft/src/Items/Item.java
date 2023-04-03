package Items;

public abstract class Item implements Comparable<Item>{
    protected double id;
    protected String name;

    public Item(double id, String name) {
        this.id = id;
        this.name = name;
    }

    public double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

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
