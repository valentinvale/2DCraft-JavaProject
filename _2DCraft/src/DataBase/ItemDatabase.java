package DataBase;

import Items.Item;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ItemDatabase {

    private Connection connection;

    public ItemDatabase() {
        this.connection = ConnectionService.getConnection();
    }

    public List<Item> getItemsByInventoryId(int inventoryId) {
        List<Item> items = new ArrayList<>(0);
        try {
            String query = "SELECT * FROM item WHERE inventory_id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, inventoryId);
            var result = preparedStatement.executeQuery();

            while (result.next()) {
                int id = result.getInt("item_id");
                String name = result.getString("name");

                if(name.contains("Stick")) {
                    items.add(new Items.Stick(id, name));
                }
                else if(name.contains("Crafting Table")){
                    items.add(new Items.CraftingTable(id, name));
                }
                else if(name.contains("Leaves")){
                    items.add(new Items.Leaves(id, name));
                }
                else if(name.contains("Log")){
                    items.add(new Items.Log(id, name));
                }
                else if(name.contains("Planks")) {
                    items.add(new Items.Planks(id, name));
                }
                else if(name.contains("Sapling")){
                    items.add(new Items.Sapling(id, name));
                }

            }
        } catch (Exception e) {
            System.out.println("Error while returning items: " + e.getMessage());
        }
        return items;
    }

    public int getMaxId(){
        try{
            String query = "SELECT MAX(item_id) FROM item";
            var preparedStatement = connection.prepareStatement(query);
            var result = preparedStatement.executeQuery();

            while(result.next()) {
                return result.getInt("MAX(item_id)");
            }
        }
        catch (Exception e){
            System.out.println("Error while returning max item id: " + e.getMessage());
        }
        return -1;
    }

    public boolean checkIfItemExists(int id){
        try{
            String query = "SELECT * FROM item WHERE item_id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            var result = preparedStatement.executeQuery();

            while(result.next()) {
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Error while checking if item exists: " + e.getMessage());
        }
        return false;
    }

    public void addItem(String name, int inventoryId) {
        try {
            String query = "INSERT INTO item(name, inventory_id) VALUES (?, ?)";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, inventoryId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error while adding item: " + e.getMessage());
        }
    }

    public void removeItem(int id) {
        try {
            String query = "DELETE FROM item WHERE item_id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error while deleting item: " + e.getMessage());
        }
    }

}
