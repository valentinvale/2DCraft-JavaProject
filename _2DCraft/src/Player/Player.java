package Player;

public class Player {

    private int id = 0;
    private String name;
    private int health;
    private Inventory inventory;
    private RecipeBook recipeBook;

    public Player(int id, String name, int health, Inventory inventory) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.inventory = inventory;
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

    public int getHealth() {
        return health;
    }

    public int getId() {
        return id;
    }

}
