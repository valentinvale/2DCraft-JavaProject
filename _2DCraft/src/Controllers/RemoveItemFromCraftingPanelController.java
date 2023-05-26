package Controllers;

import Services.MainService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RemoveItemFromCraftingPanelController {

    public Stage primaryStage;

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    public void handleRemoveItemFromCraftingPanel(javafx.event.ActionEvent actionEvent) {
        // Handle "Remove Item From Crafting Panel" button action
        Button clickedButton = (Button) actionEvent.getSource();
        int panelNumber = Integer.parseInt(clickedButton.getText());
        MainService.getCurrentPlayer().getInventory().removeItemFromCraftingPanel(panelNumber);
    }

    public void handleBackButton(javafx.event.ActionEvent actionEvent) {
        // Handle "Back" button action
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/OpenInventoryMenu.fxml"));
            Parent openInventoryMenuRoot = fxmlLoader.load();
            OpenInventoryMenuController openInventoryMenuController = fxmlLoader.getController();
            openInventoryMenuController.setPrimaryStage(primaryStage);

            Scene openInventoryMenuScene = new Scene(openInventoryMenuRoot, 800, 600);
            primaryStage.setScene(openInventoryMenuScene);
        }
        catch (Exception e) {
            System.out.println("Error while loading ChoosePlayer.fxml: " + e.getMessage());
        }
    }

    public void reloadScene() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/RemoveItemFromCraftingPanel.fxml"));
            Parent removeItemFromCraftingPanelRoot = fxmlLoader.load();
            RemoveItemFromCraftingPanelController removeItemFromCraftingPanelController = fxmlLoader.getController();
            removeItemFromCraftingPanelController.setPrimaryStage(primaryStage);

            Scene removeItemFromCraftingPanelScene = new Scene(removeItemFromCraftingPanelRoot, 800, 600);
            primaryStage.setScene(removeItemFromCraftingPanelScene);
        }
        catch (Exception e) {
            System.out.println("Error while loading ChoosePlayer.fxml: " + e.getMessage());
        }
    }

}
