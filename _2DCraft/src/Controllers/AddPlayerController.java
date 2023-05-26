package Controllers;

import Player.Player;
import Services.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class AddPlayerController {

    @FXML
    private javafx.scene.control.Button backButton;
    @FXML
    private javafx.scene.control.TextField playerName;

    private Parent mainMenuRoot;
    private Stage primaryStage;

    @FXML
    public void initialize() {
        // Initialize the controller
        playerName.setPrefWidth(100);
    }
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    public void setMainMenuRoot(Parent mainMenuRoot) {
        this.mainMenuRoot = mainMenuRoot;
    }

    public void handleAddPlayer(javafx.event.ActionEvent actionEvent) {
        // Handle "New Game" button action
        String name = playerName.getText();
        System.out.println(name);
        MainService.addNewPlayer(name);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/MainMenu.fxml"));
            Parent mainMenuRoot = fxmlLoader.load();
            MainMenuController mainMenuController = fxmlLoader.getController();
            mainMenuController.setPrimaryStage(primaryStage);

            Scene mainMenuScene = new Scene(mainMenuRoot, 800, 600);
            primaryStage.setScene(mainMenuScene);
        } catch (Exception e) {
            System.out.println("Error while loading MainMenu.fxml: " + e.getMessage());
        }
    }

    public void handleBackButton(javafx.event.ActionEvent actionEvent) {
        // Handle "Back" button action
        System.out.println("Back clicked");

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/MainMenu.fxml"));
            Parent mainMenuRoot = fxmlLoader.load();
            MainMenuController mainMenuController = fxmlLoader.getController();
            mainMenuController.setPrimaryStage(primaryStage);

            Scene mainMenuScene = new Scene(mainMenuRoot, 800, 600);
            primaryStage.setScene(mainMenuScene);
        } catch (Exception e) {
            System.out.println("Error while loading MainMenu.fxml: " + e.getMessage());
        }
    }

}
