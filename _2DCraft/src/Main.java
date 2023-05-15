import Blocks.*;
import DataBase.PlayerDatabase;
import Player.*;
import Items.*;
import Services.ConsoleService;
import Services.MainService;
import Services.TerminalService;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args){

        PlayerDatabase playerDatabase = new PlayerDatabase();

        //playerDatabase.addPlayer("Player1", 100);
        //playerDatabase.addPlayer("Player2", 100);

        //playerDatabase.printAllPlayers();

        TerminalService.start();
    }
}