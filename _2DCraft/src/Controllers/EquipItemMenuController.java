package Controllers;

import Items.Item;
import Services.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class EquipItemMenuController {

    private Stage primaryStage;

    @FXML
    private VBox inventoryItemsContainer;

    private List<Item> itemList = MainService.getCurrentPlayer().getInventory().getItems();

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    public void initialize() {
        Button itemButton;
        for (Item item : itemList) {
            itemButton = new Button(item.getName());
            itemButton.setOnAction(event -> {
                MainService.equipItem(itemList.indexOf(item)); // !!!
                reloadScene();
            });
            inventoryItemsContainer.getChildren().add(itemButton);
        }
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/EquipItemMenu.fxml"));
            Parent equipItemMenuRoot = fxmlLoader.load();
            EquipItemMenuController equipItemMenuController = fxmlLoader.getController();
            equipItemMenuController.setPrimaryStage(primaryStage);

            Scene equipItemMenuScene = new Scene(equipItemMenuRoot, 800, 600);
            primaryStage.setScene(equipItemMenuScene);
        }
        catch (Exception e) {
            System.out.println("Error while loading ChoosePlayer.fxml: " + e.getMessage());
        }
    }

}
