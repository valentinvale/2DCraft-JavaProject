package DataBase;

import Player.Player;

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
        List<Player> players = new ArrayList<Player>(0);
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

                players.add(player);

            }

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
        }
        catch (Exception e){
            System.out.println("Error while removing player: " + e.getMessage());
        }
    }

}
