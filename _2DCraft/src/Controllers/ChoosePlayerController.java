package Controllers;

import Services.MainService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Player.Player;

import java.util.List;

public class ChoosePlayerController {

    private Stage primaryStage;

    @FXML
    private VBox playerButtonsContainer;

    private List<Player> playerList = MainService.getPlayerList();

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    public void initialize() {
        // Create buttons for each player and add them to the playerButtonsContainer
        for (Player player : playerList) {
            Button playerButton = new Button(player.getName());
            playerButton.setOnAction(event -> handlePlayerButton(player));
            playerButton.setId("playerButton");
            playerButtonsContainer.getChildren().add(playerButton);
        }
    }

    @FXML
    public void handlePlayerButton(Player player) {
        // Handle player button action
        System.out.println("Player button clicked");
        System.out.println(player.getName());
        MainService.choosePlayer(playerList.indexOf(player)+1);
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

    @FXML
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


}
