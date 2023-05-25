package DataBase;

import Services.AuditService;

import java.sql.Connection;

public class RecipebookDatabase {

    Connection connection;

    public RecipebookDatabase() {
        this.connection = ConnectionService.getConnection();
    }

    public void addRecipebook(String unlockstring, int playerId){
        try{
            String query = "INSERT INTO recipebook (unlockstring, player_id) VALUES (?, ?)";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, unlockstring);
            preparedStatement.setInt(2, playerId);
            preparedStatement.executeUpdate();

            AuditService.writeAction("Add recipebook");

        }
        catch (Exception e){
            System.out.println("Error while adding recipebook: " + e.getMessage());
        }
    }

    public String getUnlockstring(int player_id){
        try{
            String query = "SELECT unlockstring FROM recipebook WHERE player_id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, player_id);
            var result = preparedStatement.executeQuery();

            while(result.next()){
                AuditService.writeAction("Get unlockstring");
                return result.getString("unlockstring");
            }
        }
        catch (Exception e){
            System.out.println("Error while getting unlockstring: " + e.getMessage());
        }
        return null;
    }

    public void updateUnlockString(int playerId, int index){

        String unlockstring = getUnlockstring(playerId);
        String newUnlockstring = "";

        for(int i = 0; i < unlockstring.length(); i++){
            if(i == index){
                newUnlockstring = unlockstring.substring(0, i) + "1" + unlockstring.substring(i + 1);
            }
        }

        try{
            String query = "UPDATE recipebook SET unlockstring = ? WHERE player_id = ?";
            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newUnlockstring);
            preparedStatement.setInt(2, playerId);
            preparedStatement.executeUpdate();

            AuditService.writeAction("Update unlockstring");

        }
        catch (Exception e){
            System.out.println("Error while updating unlockstring: " + e.getMessage());
        }

    }

}
