package Controllers;

import Items.Item;
import Services.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Controllers.AddItemToCraftingPanelController;

import java.util.List;

public class OpenInventoryMenuController {

    private Stage primaryStage;

    @FXML
    private VBox inventoryItemsContainer;
    @FXML
    private Label craftingPanelItems;
    @FXML
    private Label playerName;
    @FXML
    private Label equippedItemLabel;
    @FXML
    private Label craftingResultLabel;

    private List<Item> itemList = MainService.getCurrentPlayer().getInventory().getItems();
    private List<Item> craftingPanels = MainService.getCurrentPlayer().getInventory().getCraftingPanels();


    @FXML
    public void initialize() {
        playerName.setText(MainService.getCurrentPlayer().getName());
        String p1String, p2String, p3String, p4String, craftingResultString, equippedItemString;
        if(craftingPanels.get(0) != null) {
            p1String = craftingPanels.get(0).getName();
        } else {
            p1String = "Empty";
        }
        if(craftingPanels.get(1) != null) {
            p2String = craftingPanels.get(1).getName();
        } else {
            p2String = "Empty";
        }
        if(craftingPanels.get(2) != null) {
            p3String = craftingPanels.get(2).getName();
        } else {
            p3String = "Empty";
        }
        if(craftingPanels.get(3) != null) {
            p4String = craftingPanels.get(3).getName();
        } else {
            p4String = "Empty";
        }
        if(MainService.getCurrentPlayer().getInventory().getCraftingResult() != null) {
            craftingResultString = "Result: " + MainService.getCurrentPlayer().getInventory().getCraftingResultAmount() + "x " + MainService.getCurrentPlayer().getInventory().getCraftingResult().getName();
        } else {
            craftingResultString = "Result: Empty";
        }
        if(MainService.getCurrentPlayer().getInventory().getEquippedItem() != null) {
            equippedItemString = "Equipped Item: " + MainService.getCurrentPlayer().getInventory().getEquippedItem().getName();
        } else {
            equippedItemString = "Equipped Item: Empty";
        }

        craftingPanelItems.setText(p1String + " | " + p2String + "\n" + p3String + " | " + p4String + "\n");
        craftingResultLabel.setText(craftingResultString + "\n");
        equippedItemLabel.setText(equippedItemString + "\n");

        Label items = new Label("");
        for(int i = 0; i < itemList.size(); i++) {
            if(i != itemList.size()-1){
                items.setText(items.getText() + itemList.get(i).getName() + ", ");
            } else {
                items.setText(items.getText() + itemList.get(i).getName() + '\n');
            }
        }
        inventoryItemsContainer.getChildren().add(items);

    }

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    public void handleAddItemToCraftingPanel(javafx.event.ActionEvent actionEvent) {
        // Handle "Add Item to Crafting Panel" button action
        System.out.println("Add Item to Crafting Panel clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/AddItemToCraftingPanel.fxml"));
            Parent addItemToCraftingPanelRoot = fxmlLoader.load();
            AddItemToCraftingPanelController addItemToCraftingPanelMenuController = fxmlLoader.getController();
            addItemToCraftingPanelMenuController.setPrimaryStage(primaryStage);

            Scene addItemToCraftingPanelScene = new Scene(addItemToCraftingPanelRoot, 800, 600);
            primaryStage.setScene(addItemToCraftingPanelScene);
        } catch (Exception e) {
            System.out.println("Error while loading AddItemToCraftingPanelMenu.fxml: " + e.getMessage());
        }
    }

    @FXML
    public void handleRemoveItemFromCraftingPanel(javafx.event.ActionEvent actionEvent) {
        // Handle "Remove Item from Crafting Panel" button action
        System.out.println("Remove Item from Crafting Panel clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/RemoveItemFromCraftingPanel.fxml"));
            Parent removeItemFromCraftingPanelRoot = fxmlLoader.load();
            RemoveItemFromCraftingPanelController removeItemFromCraftingPanelController = fxmlLoader.getController();
            removeItemFromCraftingPanelController.setPrimaryStage(primaryStage);

            Scene removeItemFromCraftingPanelScene = new Scene(removeItemFromCraftingPanelRoot, 800, 600);
            primaryStage.setScene(removeItemFromCraftingPanelScene);
        } catch (Exception e) {
            System.out.println("Error while loading RemoveItemFromCraftingPanelMenu.fxml: " + e.getMessage());
        }
    }

    @FXML
    public void handleCraftItem(javafx.event.ActionEvent actionEvent) {
        // Handle "Craft Item" button action
         MainService.craftItem();
         reloadScene();
    }

    @FXML
    public void handleEquipItem(javafx.event.ActionEvent actionEvent) {
        // Handle "Equip Item" button action
        System.out.println("Equip Item clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/EquipItemMenu.fxml"));
            Parent equipItemRoot = fxmlLoader.load();
            EquipItemMenuController equipItemController = fxmlLoader.getController();
            equipItemController.setPrimaryStage(primaryStage);

            Scene equipItemScene = new Scene(equipItemRoot, 800, 600);
            primaryStage.setScene(equipItemScene);
        } catch (Exception e) {
            System.out.println("Error while loading EquipItemMenu.fxml: " + e.getMessage());
        }
    }

    @FXML
    public void handleUnequipItem(javafx.event.ActionEvent actionEvent) {
        // Handle "Unequip Item" button action
        System.out.println("Unequip Item clicked");
        MainService.unequipItem();
        reloadScene();
    }

    public void handleRemoveItemFromInventory(javafx.event.ActionEvent actionEvent) {
        // Handle "Drop Item" button action
        System.out.println("Drop Item clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/RemoveItemFromInventoryMenu.fxml"));
            Parent removeItemFromInventoryRoot = fxmlLoader.load();
            RemoveItemFromInventoryMenuController removeItemFromInventoryController = fxmlLoader.getController();
            removeItemFromInventoryController.setPrimaryStage(primaryStage);

            Scene removeItemFromInventoryScene = new Scene(removeItemFromInventoryRoot, 800, 600);
            primaryStage.setScene(removeItemFromInventoryScene);
        } catch (Exception e) {
            System.out.println("Error while loading RemoveItemFromInventory.fxml: " + e.getMessage());
        }
    }

    public void handleUseEquippedItem(javafx.event.ActionEvent actionEvent) {
        // Handle "Use Item" button action
        System.out.println("Use Item clicked");
        MainService.useItem();
        reloadScene();
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

    public void reloadScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/OpenInventoryMenu.fxml"));
            Parent inventoryMenuRoot = fxmlLoader.load();
            OpenInventoryMenuController inventoryMenuController = fxmlLoader.getController();
            inventoryMenuController.setPrimaryStage(primaryStage);

            Scene inventoryMenuScene = new Scene(inventoryMenuRoot, 800, 600);
            primaryStage.setScene(inventoryMenuScene);
        } catch (Exception e) {
            System.out.println("Error while loading InventoryMenu.fxml: " + e.getMessage());
        }
    }


}
