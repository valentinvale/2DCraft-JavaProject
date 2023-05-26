package Controllers;

import java.util.List;

import Services.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Player.Player;
public class RemovePlayerController {

    private Stage primaryStage;
    @FXML
    private VBox playerButtonsContainer;
    private List<Player> playerList = MainService.getPlayerList();

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    public void initialize() {
        // Create buttons for each player and add them to the playerButtonsContainer
        for (Player player : playerList) {
            Button playerButton = new Button(player.getName());
            playerButton.setOnAction(event -> handlePlayerButton(player));
            playerButton.setId("playerButton");
            playerButtonsContainer.getChildren().add(playerButton);
        }
    }

    public void handlePlayerButton(Player player) {
        // Handle player button action
        System.out.println("Player button clicked");
        System.out.println(player.getName());
        MainService.removePlayer(playerList.indexOf(player));
        reloadScene();
    }

    public void handleBackButton(javafx.event.ActionEvent actionEvent) {
        // Handle "Back" button action
        System.out.println("Back clicked");
        try{
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

    private void reloadScene() {
        try {
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

}
