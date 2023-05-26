package Controllers;

import Blocks.Block;
import Services.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class BreakBlocksMenuController {

    private Stage primaryStage;
    private List<Block> blockList = MainService.getExistingBlocksList();

    @FXML
    private VBox blocksContainer;

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    public void initialize() {
        int numberOfBlocksToGenerate = 5;
        // Create buttons for each block and add them to the blocksContainer
        for (Block block : blockList) {
            Button blockButton = new Button(block.getName());
            blockButton.setOnAction(event -> {
                MainService.breakBlock(blockList.indexOf(block)); // !!!
                if(MainService.getExistingBlocksList().size() < numberOfBlocksToGenerate)
                    MainService.generateOneRandomBlock();
                reloadScene();
            });
            blockButton.setId("blockButton");
            blocksContainer.getChildren().add(blockButton);

        }
    }

    @FXML
    public void handleBackButton(javafx.event.ActionEvent actionEvent) {
        // Handle "Back" button action
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/PlayerMenu.fxml"));
            Parent playerMenuRoot = fxmlLoader.load();
            PlayerMenuController playerMenuController = fxmlLoader.getController();
            playerMenuController.setPrimaryStage(primaryStage);

            Scene playerMenuScene = new Scene(playerMenuRoot, 800, 600);
            primaryStage.setScene(playerMenuScene);
        } catch (Exception e) {
            System.out.println("Error while loading PlayerMenu.fxml: " + e.getMessage());
        }
    }

    public void reloadScene() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/BreakBlocksMenu.fxml"));
            Parent breakBlocksMenuRoot = fxmlLoader.load();
            BreakBlocksMenuController breakBlocksMenuController = fxmlLoader.getController();
            breakBlocksMenuController.setPrimaryStage(primaryStage);

            Scene breakBlocksMenuScene = new Scene(breakBlocksMenuRoot, 800, 600);
            primaryStage.setScene(breakBlocksMenuScene);
        } catch (Exception e) {
            System.out.println("Error while loading BreakBlocksMenu.fxml: " + e.getMessage());
        }
    }

}
