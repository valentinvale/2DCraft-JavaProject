package DataBase;

import Items.Item;
import Player.Inventory;

import java.sql.Connection;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InventoryDatabase {

    private Connection connection;

    public InventoryDatabase() {
        this.connection = ConnectionService.getConnection();
    }

    public Inventory getInventoryByPlayerId(int playerId){
        ItemDatabase itemDatabase = new ItemDatabase();
        try{
            String query = "SELECT * FROM inventory WHERE player_id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, playerId);
            var result = preparedStatement.executeQuery();

            while(result.next()) {
                int id = result.getInt("inventory_id");

                Inventory inventory = new Inventory(id, 10);

                List<Item> items = itemDatabase.getItemsByInventoryId(id);
                Collections.sort(items);

                inventory.setItems(items);

                return inventory;
            }
        }
        catch (Exception e){
            System.out.println("Error while returning inventory: " + e.getMessage());
        }
        return null;
    }

    public int getMaxId() {
        int maxId = 0;
        try {
            String query = "SELECT ISEQ$$_80454.nextval FROM dual";
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


    public void addInventory(int playerId){
        try{
            String query = "INSERT INTO inventory(player_id) VALUES (?)";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, playerId);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            System.out.println("Error while adding inventory: " + e.getMessage());
        }
    }

    public void removeInventory(int id){
        try{
            String query = "DELETE FROM inventory WHERE inventory_id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            System.out.println("Error while removing inventory: " + e.getMessage());
        }
    }



}
