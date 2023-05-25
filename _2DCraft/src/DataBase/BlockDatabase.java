package DataBase;

import Blocks.Block;
import Services.AuditService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BlockDatabase {

    Connection connection;

    public BlockDatabase() {
        this.connection = ConnectionService.getConnection();
    }

    public void addBlock(String name){
        try{
            String query = "INSERT INTO block (name) VALUES (?)";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

            AuditService.writeAction("Add block");

        }
        catch (Exception e){
            System.out.println("Error while adding block: " + e.getMessage());
        }
    }

    public List<Block> getAllBlocks(){
        List<Block> blocks = new ArrayList<>();
        try{
            String query = "SELECT * FROM block";
            var preparedStatement = connection.prepareStatement(query);
            var result = preparedStatement.executeQuery();

            while(result.next()){
                AuditService.writeAction("Get all blocks");
                int id = result.getInt("block_id");
                String name = result.getString("name");

                if(name.contains("Crafting Table")){
                    blocks.add(new Blocks.CraftingTable(id, name, 0, "", 0, 0));
                }
                else if(name.contains("Leaves")){
                    blocks.add(new Blocks.Leaves(id, name, 0, "", 0, 0));
                }
                else if(name.contains("Log")){
                    blocks.add(new Blocks.Log(id, name, 0, "", 0, 0));
                }
                else if(name.contains("Planks")){
                    blocks.add(new Blocks.Planks(id, name, 0, "", 0, 0));
                }
            }

            AuditService.writeAction("Get all blocks");

            return blocks;
        }
        catch (Exception e){
            System.out.println("Error while getting all blocks: " + e.getMessage());
            return null;
        }
    }

    public int getMaxId(){
        try{
            String query = "SELECT MAX(block_id) FROM block";
            var preparedStatement = connection.prepareStatement(query);
            var result = preparedStatement.executeQuery();
            result.next();
            AuditService.writeAction("Get max id");
            return result.getInt(1);
        }
        catch (Exception e){
            System.out.println("Error while getting max id: " + e.getMessage());
            return -1;
        }
    }

    public boolean checkIfBlockExists(int id){
        try{
            String query = "SELECT * FROM block WHERE block_id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            var result = preparedStatement.executeQuery();
            AuditService.writeAction("Check if block exists");
            return result.next();
        }
        catch (Exception e){
            System.out.println("Error while checking if block exists: " + e.getMessage());
            return false;
        }
    }

    public void removeBlock(int id){
        try{
            String query = "DELETE FROM block WHERE block_id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            AuditService.writeAction("Delete block");
        }
        catch (Exception e){
            System.out.println("Error while deleting block: " + e.getMessage());
        }
    }

}
