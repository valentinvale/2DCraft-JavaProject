package Player;

public class Player {

    private String name;
    private int health;
    private Inventory inventory;
    private RecipeBook recipeBook;

    public Player(String name, int health, Inventory inventory) {
        this.name = name;
        this.health = health;
        this.inventory = new Inventory(inventory.getSize());
        this.recipeBook = new RecipeBook();

    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public RecipeBook getRecipeBook() {
        return recipeBook;
    }

}
