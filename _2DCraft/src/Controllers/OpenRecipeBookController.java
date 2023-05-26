package Controllers;

import Player.Recipe;
import Services.MainService;
import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class OpenRecipeBookController {

    private Stage primaryStage;

    @FXML
    private VBox recipeBookContainer;

    private List<Recipe> recipeList = MainService.getCurrentPlayer().getRecipeBook().getRecipes();

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    public void initialize() {
        MainService.openRecipeBook();
        boolean hasRecipes = false;
        Label noRecipesLabel = new Label("Nu ai descoperit nicio reteta inca!");
        try{
            for(Recipe recipe : recipeList) {
                Label recipeLabel = new Label("");
                if (recipe.getUnlocked()) {
                    hasRecipes = true;
                    recipeLabel.setText(recipe.getRecipeString());
                }
                if (hasRecipes)
                    recipeBookContainer.getChildren().add(recipeLabel);
            }
        }
        catch (Exception e) {
            System.out.println("Error while loading recipes: " + e.getMessage());
        }

        if(!hasRecipes)
            recipeBookContainer.getChildren().add(noRecipesLabel);

    }

    @FXML
    public void handleBackButton(javafx.event.ActionEvent actionEvent) {
        // Handle "Back" button action
        System.out.println("Back clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/PlayerMenu.fxml"));
            Parent playerMenuRoot = fxmlLoader.load();
            PlayerMenuController playerMenuController = fxmlLoader.getController();
            playerMenuController.setPrimaryStage(primaryStage);

            Scene mainMenuScene = new Scene(playerMenuRoot, 800, 600);
            primaryStage.setScene(mainMenuScene);
        } catch (Exception e) {
            System.out.println("Error while loading MainMenu.fxml: " + e.getMessage());
        }
    }

}
