package Controllers;

import Services.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class MainMenuController {

    @FXML
    private VBox root;

    private Stage primaryStage;

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    public void handleAddPlayer(javafx.event.ActionEvent actionEvent) {
        System.out.println("Add player clicked");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/AddPlayer.fxml"));
            Parent addPlayerRoot = fxmlLoader.load();
            AddPlayerController addPlayerController = fxmlLoader.getController();
            addPlayerController.setPrimaryStage(primaryStage);

            Scene addPlayerScene = new Scene(addPlayerRoot, 800, 600);
            primaryStage.setScene(addPlayerScene);
        } catch (Exception e) {
            System.out.println("Error while loading AddPlayer.fxml: " + e.getMessage());
        }
    }

    @FXML
    public void handleChoosePlayer(javafx.event.ActionEvent actionEvent) {
        // Handle "Load Game" button action
        System.out.println("Load Game clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/ChoosePlayer.fxml"));
            Parent choosePlayerRoot = fxmlLoader.load();
            ChoosePlayerController choosePlayerController = fxmlLoader.getController();
            choosePlayerController.setPrimaryStage(primaryStage);

            Scene choosePlayerScene = new Scene(choosePlayerRoot, 800, 600);
            primaryStage.setScene(choosePlayerScene);
        } catch (Exception e) {
            System.out.println("Error while loading ChoosePlayer.fxml: " + e.getMessage());
        }
    }

    @FXML
    public void handleRemovePlayer(javafx.event.ActionEvent actionEvent) {
        // Handle "Options" button action
        System.out.println("Options clicked");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/RemovePlayer.fxml"));
            Parent removePlayerRoot = fxmlLoader.load();
            RemovePlayerController removePlayerController = fxmlLoader.getController();
            removePlayerController.setPrimaryStage(primaryStage);

            Scene removePlayerScene = new Scene(removePlayerRoot, 800, 600);
            primaryStage.setScene(removePlayerScene);
        } catch (Exception e) {
            System.out.println("Error while loading RemovePlayer.fxml: " + e.getMessage());
        }
    }

    @FXML
    public void handleSaveGame(javafx.event.ActionEvent actionEvent) {
        // Handle "Save Game" button action
        MainService.saveGame();
    }

    @FXML
    public void handleExit(javafx.event.ActionEvent actionEvent) {
        // Handle "Exit" button action
        System.out.println("Exit clicked");
        System.exit(0);
    }

}
