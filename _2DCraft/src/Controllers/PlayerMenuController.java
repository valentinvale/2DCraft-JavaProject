package Controllers;

import Services.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerMenuController {

    private Stage primaryStage;
    @FXML
    private Label playerName = new Label(MainService.getCurrentPlayer().getName());

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    public void initialize() {
        playerName.setText(MainService.getCurrentPlayer().getName());
    }

    public void handleOpenInventory(javafx.event.ActionEvent actionEvent) {
        // Handle "Open Inventory" button action
        System.out.println("Open Inventory clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/OpenInventoryMenu.fxml"));
            Parent openInventoryRoot = fxmlLoader.load();
            OpenInventoryMenuController openInventoryMenuController = fxmlLoader.getController();
            openInventoryMenuController.setPrimaryStage(primaryStage);

            Scene openInventoryScene = new Scene(openInventoryRoot, 800, 600);
            primaryStage.setScene(openInventoryScene);
        }
        catch (Exception e) {
            System.out.println("Error while loading OpenInventoryMenu.fxml: " + e.getMessage());
        }
    }

    public void handleOpenRecipeBook(javafx.event.ActionEvent actionEvent) {
        // Handle "Open Recipe Book" button action
        System.out.println("Open Recipe Book clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/OpenRecipeBook.fxml"));
            Parent recipeBookRoot = fxmlLoader.load();
            OpenRecipeBookController recipeBookMenuController = fxmlLoader.getController();
            recipeBookMenuController.setPrimaryStage(primaryStage);

            Scene recipeBookScene = new Scene(recipeBookRoot, 800, 600);
            primaryStage.setScene(recipeBookScene);
        }
        catch (Exception e) {
            System.out.println("Error while loading RecipeBookMenu.fxml: " + e.getMessage());
        }
    }

    public void handleBreakBlocks(javafx.event.ActionEvent actionEvent) {
        // Handle "Break Blocks" button action
        System.out.println("Break Blocks clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/BreakBlocksMenu.fxml"));
            Parent breakBlocksRoot = fxmlLoader.load();
            BreakBlocksMenuController breakBlocksMenuController = fxmlLoader.getController();
            breakBlocksMenuController.setPrimaryStage(primaryStage);

            Scene breakBlocksScene = new Scene(breakBlocksRoot, 800, 600);
            primaryStage.setScene(breakBlocksScene);
        }
        catch (Exception e) {
            System.out.println("Error while loading BreakBlocksMenu.fxml: " + e.getMessage());
        }
    }

    public void handleBackButton(javafx.event.ActionEvent actionEvent) {
        // Handle "Back" button action
        System.out.println("Back clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/ChoosePlayer.fxml"));
            Parent choosePlayerRoot = fxmlLoader.load();
            ChoosePlayerController choosePlayerController = fxmlLoader.getController();
            choosePlayerController.setPrimaryStage(primaryStage);

            Scene choosePlayerScene = new Scene(choosePlayerRoot, 800, 600);
            primaryStage.setScene(choosePlayerScene);
        }
        catch (Exception e) {
            System.out.println("Error while loading ChoosePlayer.fxml: " + e.getMessage());
        }
    }



}
