package DataBase;

import java.sql.Connection;

public class PlayerDatabase {
    private Connection connection;

    public PlayerDatabase() {
        this.connection = ConnectionService.getConnection();
    }

    public void printAllPlayers() {
        try{
            String query = "SELECT * FROM player";
            var statement = connection.createStatement();
            var result = statement.executeQuery(query);

            while(result.next()) {
                System.out.println(result.getInt("id") + " " + result.getString("name") + " " + result.getInt("health"));

            }
        }
        catch (Exception e){
            System.out.println("Error while printing all players: " + e.getMessage());
        }
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

}
