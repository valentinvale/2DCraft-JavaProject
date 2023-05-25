package DataBase;

import Player.Player;
import Services.AuditService;
import Services.MainService;
import Player.Recipe;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PlayerDatabase {
    private Connection connection;

    public PlayerDatabase() {
        this.connection = ConnectionService.getConnection();
    }

    public List<Player> getAllPlayers() {
        InventoryDatabase inventoryDatabase = new InventoryDatabase();
        RecipebookDatabase recipebookDatabase = new RecipebookDatabase();
        List<Player> players = new ArrayList<Player>(0);
        List<Recipe> recipeList = MainService.getRecipeList();
        try{
            String query = "SELECT * FROM player";
            var statement = connection.createStatement();
            var result = statement.executeQuery(query);

            while(result.next()) {

                int id = result.getInt("id");
                String name = result.getString("name");
                int health = result.getInt("health");


                var inventory = inventoryDatabase.getInventoryByPlayerId(id);

                Player player = new Player(id, name, health, inventory);

                for(Recipe recipe : recipeList){
                    Recipe aux = new Recipe(recipe);
                    player.getRecipeBook().addRecipe(aux);
                }

                String unlockString = recipebookDatabase.getUnlockstring(id);
                //System.out.println(unlockString);
                for(int i = 0; i < unlockString.length(); i++){
                    if(unlockString.charAt(i) == '1'){
                        player.getRecipeBook().getRecipes().get(i).unlock();
                    }
                }
                players.add(player);

            }

            AuditService.writeAction("Get all players");

        }
        catch (Exception e){
            System.out.println("Error while printing all players: " + e.getMessage());
        }

        return players;
    }

    public int getMaxId() {
        int maxId = 0;
        try {
            String query = "SELECT ISEQ$$_80429.nextval FROM dual";
            var statement = connection.createStatement();
            var result = statement.executeQuery(query);

            while (result.next()) {
                maxId = result.getInt(1);
            }

            AuditService.writeAction("Get player max id");

        } catch (Exception e) {
            System.out.println("Error while getting max id: " + e.getMessage());
        }
        return maxId;
    }

    public boolean checkIfPlayerExists(int id){
        try{
            String query = "SELECT * FROM player WHERE id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            var result = preparedStatement.executeQuery();

            while(result.next()) {
                AuditService.writeAction("Check if player exists");
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Error while checking if player exists: " + e.getMessage());
        }
        return false;
    }

    public void addPlayer(String name, int health) {
        try {

            String query = "INSERT INTO player(name, health) VALUES (?, ?)";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, health);
            preparedStatement.executeUpdate();

            AuditService.writeAction("Add player");

        }
        catch (Exception e){
            System.out.println("Error while adding player: " + e.getMessage());

        }

    }

    public void removePlayer(int id) {
        try {
            String query = "DELETE FROM player WHERE id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            AuditService.writeAction("Remove player");
        }
        catch (Exception e){
            System.out.println("Error while removing player: " + e.getMessage());
        }
    }

}
