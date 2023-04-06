import Blocks.*;
import Player.*;
import Items.*;
import Services.ConsoleService;
import Services.MainService;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

//        Set<Player> playerList = new HashSet<>();
//
//        Inventory inventory = new Inventory(20);
//        RecipeBook recipeBook = new RecipeBook();
//        Recipe oakPlanksRecipe = new Recipe("Oak Planks", new ArrayList<Item>(Arrays.asList(new Items.Log(1, "Oak Log"))), new Items.Planks(2, "Oak Planks"), 4);
//        Recipe craftingTableRecipe = new Recipe("Crafting Table", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Oak Planks"), new Items.Planks(2, "Oak Planks"), null, new Items.Planks(2, "Oak Planks"), new Items.Planks(2, "Oak Planks"))), new Items.CraftingTable(4, "Crafting Table"), 1);
//        Recipe stickRecipe = new Recipe("Stick", new ArrayList<Item>(Arrays.asList(new Items.Planks(2, "Oak Planks"), null, null, new Items.Planks(2, "Oak Planks"))), new Items.Stick(3, "Stick"), 4);
//
//        recipeBook.addRecipe(oakPlanksRecipe);
//        recipeBook.addRecipe(craftingTableRecipe);
//        recipeBook.addRecipe(stickRecipe);
//
//        System.out.println(inventory.getItems().size());
//        Player player = new Player("Player", 100, inventory, recipeBook);
//        playerList.add(player);
//
//        player.getRecipeBook().openRecipeBook(player);
//
//        Block OakLeavesBlock = new Blocks.Leaves(0, "Oak Leaves", 100, "Oak.png", 0, 0);
//        Block OakLogBlock = new Blocks.Log(1, "Oak Log", 100, "Oak.png", 0, 0);
//        System.out.println(player.getInventory().getItems().size());
//        OakLeavesBlock.dropItem(player);
//        OakLogBlock.dropItem(player);
//        OakLogBlock.dropItem(player);
//        OakLogBlock.dropItem(player);
//        OakLogBlock.dropItem(player);
//        //System.out.println(player.getInventory().getItems().size());
//        player.getInventory().showInventory();
//
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Log"), 1);
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Log"), 2);
////        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Log"), 3);
////        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Log"), 4);
//        player.getInventory().showInventory();
////
//        player.getInventory().removeItemFromCraftingPanel(1);
//
//        player.getInventory().showInventory();
//
//        player.getInventory().craftItem();
//        player.getInventory().showInventory();
//
//        player.getRecipeBook().openRecipeBook(player);
//
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 1);
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 2);
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 3);
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 4);
//        player.getInventory().showInventory();
//        player.getInventory().craftItem();
//
//        player.getInventory().showInventory();
//
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Log"), 1);
//        player.getInventory().showInventory();
//        player.getInventory().craftItem();
//        player.getInventory().showInventory();
//
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 1);
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 3);
//        player.getInventory().showInventory();
//        player.getInventory().craftItem();
//        player.getInventory().showInventory();
//
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 2);
//        player.getInventory().addItemToCraftingPanel(new Items.Log(1, "Oak Planks"), 4);
//        player.getInventory().showInventory();
//        player.getInventory().craftItem();
//        player.getInventory().showInventory();
//
//        player.getInventory().equipItem(player.getInventory().getItemByName("Stick"));
//        player.getInventory().showInventory();
//        player.getInventory().equipItem(player.getInventory().getItemByName("Crafting Table"));
//        player.getInventory().showInventory();
//        player.getInventory().unequipItem();
//        player.getInventory().showInventory();
//        player.getInventory().equipItem(player.getInventory().getItemByName("Oak Planks"));
//
//        player.getRecipeBook().openRecipeBook(player);
//
//        for(Player p : playerList){
//            System.out.println(p.getName());
//            player.getInventory().showInventory();
//        }

        Scanner scanner = new Scanner(System.in);
        String input;
        String inputPlayerMenu;
        String inputInventoryMenu;
        String inputIndexItem;
        String inputActiuneItem;

        do {
            ConsoleService.clearScreen();
            System.out.println("Tasteaza numarul optiunii dorite: ");
            System.out.println("1. Creeaza un jucator");
            System.out.println("2. Afiseaza jucatorii");
            System.out.println("0. Iesire");
            input = scanner.nextLine();
            if(Objects.equals(input, "1")) {
                ConsoleService.clearScreen();
                System.out.println("Introduceti numele jucatorului: ");
                String playerName = scanner.nextLine();
                MainService.addNewPlayer(playerName);
                ConsoleService.pressAnyKeyToContinue();
            }
            else if(Objects.equals(input, "2")) {
                ConsoleService.clearScreen();
                System.out.println("Introduceti numarul jucatorului cu care vreti sa jucati: ");
                MainService.showPlayerList();
                int playerNumber = parseInt(scanner.nextLine());

                MainService.choosePlayer(playerNumber);
                MainService.getCurrentPlayer().getInventory().addItem(new Items.Log(1, "Oak Log"));
                MainService.getCurrentPlayer().getInventory().addItem(new Items.Log(1, "Oak Log"));

                do{

                    System.out.println(MainService.getCurrentPlayer().getName());
                    System.out.println("--------------------");
                    System.out.println("1. Deschide inventarul");
                    System.out.println("2. Deschide cartea de retete");
                    System.out.println("0. Iesire");
                    inputPlayerMenu = scanner.nextLine();
                    if(inputPlayerMenu.equals("1")){
                        ConsoleService.clearScreen();
                        do{

                            System.out.println("Introduceti numarul actiunii dorite! ");
                            System.out.println("1. Adauga un item in crafting panel");
                            System.out.println("2. Elimina un item din crafting panel");
                            System.out.println("3. Crafteaza itemul");
                            System.out.println("4. Echipeaza itemul");
                            System.out.println("5. Dezchipeaza itemul");
                            System.out.println("6. Elimina item din inventar");
                            System.out.println("0. Iesire");

                            MainService.openInventory();
                            inputInventoryMenu = scanner.nextLine();
                            if(inputInventoryMenu.equals("0")){
                                MainService.closeInventory();
                            }
                            else if(inputInventoryMenu.equals("1")){
                                ConsoleService.clearScreen();
                                System.out.println("Introduceti numarul itemului pe care doriti sa il adaugati in crafting panel: ");
                                inputIndexItem = scanner.nextLine();
                                if(!inputIndexItem.matches("[0-9]+")) {
                                    System.out.println("Optiune invalida!");
                                    ConsoleService.pressAnyKeyToContinue();
                                }
                                else{
                                    int indexItem = parseInt(inputIndexItem) - 1;
                                    if(indexItem >= MainService.getCurrentPlayer().getInventory().getItems().size() || indexItem < 0){
                                        System.out.println("Optiune invalida!");
                                        ConsoleService.pressAnyKeyToContinue();
                                    }
                                    else{
                                        String inputPanel;
                                        System.out.println("Introduceti numarul panelului in care doriti sa adaugati itemul: ");
                                        inputPanel = scanner.nextLine();
                                        if(!inputPanel.matches("[0-9]+")) {
                                            System.out.println("Optiune invalida!");
                                            ConsoleService.pressAnyKeyToContinue();
                                        }
                                        else{
                                            int panel = parseInt(inputPanel);
                                            if(panel > 4 || panel < 1){
                                                System.out.println("Optiune invalida!");
                                                ConsoleService.pressAnyKeyToContinue();
                                            }
                                            else{
                                                MainService.addItemToCraftingPanel(indexItem, panel);
                                                ConsoleService.pressAnyKeyToContinue();
                                            }
                                        }
                                    }

                                }


                            }
                            else if(inputInventoryMenu.equals("2")){
                                ConsoleService.clearScreen();
                                System.out.println("Introduceti numarul crafting panelului din care doriti sa eliminati itemul: ");
                                String inputCraftingPanel = scanner.nextLine();
                                if(!inputCraftingPanel.matches("[0-9]+")) {
                                    System.out.println("Optiune invalida!");
                                    ConsoleService.pressAnyKeyToContinue();
                                }
                                else{
                                    int craftingPanel = parseInt(inputCraftingPanel);
                                    if(craftingPanel > 4 || craftingPanel < 1){
                                        System.out.println("Optiune invalida!");
                                        ConsoleService.pressAnyKeyToContinue();
                                    }
                                    else{
                                        MainService.removeItemFromCraftingPanel(craftingPanel);
                                        ConsoleService.pressAnyKeyToContinue();
                                    }
                                }
                            }
                            else if(inputInventoryMenu.equals("3")){
                                ConsoleService.clearScreen();
                                MainService.craftItem();
                                System.out.println("*Zgomote de craftare*\nItemul a fost craftat!");
                                ConsoleService.pressAnyKeyToContinue();
                            }

                        }while(!inputInventoryMenu.equals("0"));

                    }
                    else if(inputPlayerMenu.equals("2")) {
                        ConsoleService.clearScreen();
                        MainService.openRecipeBook();
                        ConsoleService.pressAnyKeyToContinue();
                    }
                }while(!inputPlayerMenu.equals("0"));


            }
            else{
                if(!Objects.equals(input, "0"))
                {
                    System.out.println("Optiune invalida!");
                    ConsoleService.clearScreen();
                    ConsoleService.pressAnyKeyToContinue();
                }



            }

        }
        while(!Objects.equals(input, "0"));


    }
}