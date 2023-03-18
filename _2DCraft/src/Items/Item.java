package Items;

public abstract class Item {
    private double id;
    private String name;

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
}
