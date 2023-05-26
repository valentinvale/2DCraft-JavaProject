package Controllers;

import Items.Item;
import Services.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.util.List;

public class AddItemToCraftingPanelController {

    private Stage primaryStage;
    private List<Item> itemList = MainService.getCurrentPlayer().getInventory().getItems();

    @FXML
    private ChoiceBox itemChoiceBox;

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    public void initialize() {
        for (Item item : itemList) {
            itemChoiceBox.getItems().add(item.getName());
        }
    }

    public void handleAddItemToCraftingPanel(javafx.event.ActionEvent actionEvent) {
        // Handle "Add Item To Crafting Panel" button action
        System.out.println("Add Item To Crafting Panel clicked");
        String selectedItem = null;
        try{
            selectedItem = itemChoiceBox.getValue().toString();
        }
        catch (Exception e) {
            System.out.println("Nothing selected " + e.getMessage());
        }


        Button clickedButton = (Button) actionEvent.getSource();

        int panelNumber = Integer.parseInt(clickedButton.getText());

        if(clickedButton.getText() != null && itemChoiceBox.getValue() != null)
            for (Item item : itemList) {
                if (item.getName().equals(selectedItem)) {
                    MainService.getCurrentPlayer().getInventory().addItemToCraftingPanel(item, panelNumber);
                    break;
                }
            }
        reloadScene();

    }


    public void handleBackButton(javafx.event.ActionEvent actionEvent) {
        // Handle "Back" button action
        System.out.println("Back clicked");
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/AddItemToCraftingPanel.fxml"));
            Parent addItemToCraftingPanelRoot = fxmlLoader.load();
            AddItemToCraftingPanelController addItemToCraftingPanelController = fxmlLoader.getController();
            addItemToCraftingPanelController.setPrimaryStage(primaryStage);

            Scene addItemToCraftingPanelScene = new Scene(addItemToCraftingPanelRoot, 800, 600);
            primaryStage.setScene(addItemToCraftingPanelScene);
        }
        catch (Exception e) {
            System.out.println("Error while loading AddItemToCraftingPanel.fxml: " + e.getMessage());
        }
    }



}
