package Player;

import Items.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecipeBook {
    private ArrayList<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<Recipe>();
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public void printRecipes() {
        for(Recipe recipe : this.recipes) {
            if(recipe.getUnlocked())
                recipe.printRecipe();
        }
    }

    public void unlockRecipes(Player player) {
        boolean noRecipeUnlocked = true;
        for(Recipe recipe : this.recipes)
            if(recipe.getUnlocked())
                noRecipeUnlocked = false;

        if(noRecipeUnlocked){
            System.out.println("Nu cunosti nicio reteta inca! Mai colecteaza cateva iteme si revino aici!");
        }
        else{
            Set<Item> itemSet = new HashSet<>(player.getInventory().getItems());
            for(Recipe recipe : this.recipes)
                if(!recipe.getUnlocked()){
                    for(Item item: itemSet)
                        for(Item recipeItem : recipe.getCraftingPanels())
                            if(recipeItem != null &&  item.getName().equals(recipeItem.getName()))
                            {
                                recipe.unlock();

                            }
                }
        }

    }

    public void openRecipeBook(Player player) {
        this.unlockRecipes(player);
        System.out.println("Recipes:");
        this.printRecipes();
    }
}
