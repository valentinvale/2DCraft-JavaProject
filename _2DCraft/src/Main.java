
import Controllers.AddPlayerController;
import Controllers.MainMenuController;
import Services.MainService;
import Services.TerminalService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){

        //TerminalService.start();
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        int numberOfBlocksToGenerate = 5;
        MainService.loadGame();
        if(MainService.getExistingBlocksList().size() < numberOfBlocksToGenerate){
            System.out.println("Nr of existing blocks: " + MainService.getExistingBlocksList().size());
            MainService.generateRandomBlocks(numberOfBlocksToGenerate - MainService.getExistingBlocksList().size());
        }

        FXMLLoader mainMenuLoader = new FXMLLoader(getClass().getResource("FXML/MainMenu.fxml"));
        Parent mainMenuRoot = mainMenuLoader.load();
        MainMenuController mainMenuController = mainMenuLoader.getController();
        mainMenuController.setPrimaryStage(primaryStage);

        FXMLLoader addPlayerLoader = new FXMLLoader(getClass().getResource("FXML/AddPlayer.fxml"));
        Parent addPlayerRoot = addPlayerLoader.load();
        AddPlayerController addPlayerController = addPlayerLoader.getController();
        addPlayerController.setMainMenuRoot(mainMenuRoot);
        addPlayerController.setPrimaryStage(primaryStage);

        Scene scene = new Scene(mainMenuRoot, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }


}