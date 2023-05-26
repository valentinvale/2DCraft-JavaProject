package Services;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TerminalService {

    public static void start(){
        {

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
            final int numberOfBlocksToGenerate = 5;

            MainService.loadGame();

            if(MainService.getExistingBlocksList().size() < 5){
                //System.out.println("Nr of existing blocks: " + MainService.getExistingBlocksList().size());
                MainService.generateRandomBlocks(numberOfBlocksToGenerate - MainService.getExistingBlocksList().size());
            }

            do {
                ConsoleService.clearScreen();
                System.out.println("Tasteaza numarul optiunii dorite: ");
                System.out.println("1. Creeaza un jucator");
                System.out.println("2. Alege un jucator");
                System.out.println("3. Elimina un jucator");
                System.out.println("4. Salveaza jocul");
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
                    if(MainService.getPlayerList().size() == 0){
                        System.out.println("Nu exista jucatori in lista!");
                        ConsoleService.pressAnyKeyToContinue();
                        continue;
                    }

                    System.out.println("Introduceti numarul jucatorului cu care vreti sa jucati: ");
                    MainService.showPlayerList();
                    String inputPlayerNumber = scanner.nextLine();
                    if(!inputPlayerNumber.matches("[0-9]+")){
                        System.out.println("Input invalid!");
                        ConsoleService.pressAnyKeyToContinue();
                    }
                    else{
                        int playerNumber;
                        try{
                            playerNumber = Integer.parseInt(inputPlayerNumber);
                        }
                        catch (NumberFormatException e){
                            System.out.println("Input invalid!");
                            ConsoleService.pressAnyKeyToContinue();
                            continue;
                        }

                        if(playerNumber > MainService.getPlayerList().size() || playerNumber < 1) {
                            System.out.println("Input invalid!");
                            ConsoleService.pressAnyKeyToContinue();
                        }
                        else{
                            MainService.choosePlayer(playerNumber);

                            do{

                                System.out.println(MainService.getCurrentPlayer().getName());
                                System.out.println("--------------------");
                                System.out.println("1. Deschide inventarul");
                                System.out.println("2. Deschide cartea de retete");
                                System.out.println("3. Sparge block-uri");
                                System.out.println("0. Iesire");
                                inputPlayerMenu = scanner.nextLine();
                                if(inputPlayerMenu.equals("1")){
                                    ConsoleService.clearScreen();
                                    do{
                                        System.out.println("Introduceti numarul actiunii dorite! ");
                                        System.out.println("1. Adauga un item in crafting panel");
                                        System.out.println("2. Elimina un item din crafting panel");
                                        System.out.println("3. Crafteaza item-ul");
                                        System.out.println("4. Echipeaza un item");
                                        System.out.println("5. Dezechipeaza item-ul");
                                        System.out.println("6. Elimina item din inventar");
                                        System.out.println("7. Utilizeaza item-ul echipat");
                                        System.out.println("0. Iesire");
                                        System.out.println("--------------------");

                                        MainService.openInventory();
                                        inputInventoryMenu = scanner.nextLine();
                                        if(inputInventoryMenu.equals("0")){
                                            MainService.closeInventory();
                                        }
                                        else if(inputInventoryMenu.equals("1")){
                                            ConsoleService.clearScreen();
                                            System.out.println("Introduceti numarul item-ului pe care doriti sa il adaugati in crafting panel: ");
                                            inputIndexItem = scanner.nextLine();
                                            if(!inputIndexItem.matches("[0-9]+")) {
                                                System.out.println("Optiune invalida!");
                                                ConsoleService.pressAnyKeyToContinue();
                                            }
                                            else{
                                                int indexItem;
                                                try{
                                                    indexItem = parseInt(inputIndexItem) - 1;
                                                }
                                                catch (NumberFormatException e){
                                                    System.out.println("Optiune invalida!");
                                                    ConsoleService.pressAnyKeyToContinue();
                                                    continue;
                                                }

                                                if(indexItem >= MainService.getCurrentPlayer().getInventory().getItems().size() || indexItem < 0){
                                                    System.out.println("Optiune invalida!");
                                                    ConsoleService.pressAnyKeyToContinue();
                                                }
                                                else{
                                                    String inputPanel;
                                                    System.out.println("Introduceti numarul panelului in care doriti sa adaugati item-ul: ");
                                                    inputPanel = scanner.nextLine();
                                                    if(!inputPanel.matches("[0-9]+")) {
                                                        System.out.println("Optiune invalida!");
                                                        ConsoleService.pressAnyKeyToContinue();
                                                    }
                                                    else{
                                                        int panel;
                                                        try{
                                                            panel = parseInt(inputPanel);
                                                        }
                                                        catch (NumberFormatException e){
                                                            System.out.println("Optiune invalida!");
                                                            ConsoleService.pressAnyKeyToContinue();
                                                            continue;
                                                        }
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
                                            System.out.println("Introduceti numarul crafting panelului din care doriti sa eliminati item-ul: ");
                                            String inputCraftingPanel = scanner.nextLine();
                                            if(!inputCraftingPanel.matches("[0-9]+")) {
                                                System.out.println("Optiune invalida!");
                                                ConsoleService.pressAnyKeyToContinue();
                                            }
                                            else{
                                                int craftingPanel;
                                                try{
                                                    craftingPanel = parseInt(inputCraftingPanel);
                                                }
                                                catch (NumberFormatException e){
                                                    System.out.println("Optiune invalida!");
                                                    ConsoleService.pressAnyKeyToContinue();
                                                    continue;
                                                }
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
                                            System.out.println("*Zgomote de craftare*\nitem-ul a fost craftat!");
                                            ConsoleService.pressAnyKeyToContinue();
                                        }
                                        else if(inputInventoryMenu.equals("4")){
                                            ConsoleService.clearScreen();
                                            System.out.println("Introduceti numarul item-ului pe care doriti sa il echipezi: ");
                                            String indexEquipItem = scanner.nextLine();
                                            if(!indexEquipItem.matches("[0-9]+")) {
                                                System.out.println("Optiune invalida!");
                                                ConsoleService.pressAnyKeyToContinue();
                                            }
                                            else{
                                                int indexItem;
                                                try{
                                                    indexItem = parseInt(indexEquipItem) - 1;
                                                }
                                                catch (NumberFormatException e){
                                                    System.out.println("Optiune invalida!");
                                                    ConsoleService.pressAnyKeyToContinue();
                                                    continue;
                                                }
                                                if(indexItem >= MainService.getCurrentPlayer().getInventory().getItems().size() || indexItem < 0){
                                                    System.out.println("Optiune invalida!");
                                                    ConsoleService.pressAnyKeyToContinue();
                                                }
                                                else{
                                                    MainService.equipItem(indexItem);
                                                    System.out.println("item-ul a fost echipat!");
                                                    ConsoleService.pressAnyKeyToContinue();
                                                }
                                            }
                                        }
                                        else if(inputInventoryMenu.equals("5")){
                                            ConsoleService.clearScreen();
                                            if(MainService.unequipItem())
                                                System.out.println("item-ul a fost dezechipat!");
                                            else
                                                System.out.println("Nu aveti niciun item echipat!");
                                            ConsoleService.pressAnyKeyToContinue();
                                        }
                                        else if(inputInventoryMenu.equals("6")){
                                            ConsoleService.clearScreen();
                                            System.out.println("Introduceti numarul item-ului pe care doriti sa il eliminati: ");
                                            String indexDeleteItem = scanner.nextLine();
                                            if(!indexDeleteItem.matches("[0-9]+")) {
                                                System.out.println("Optiune invalida!");
                                                ConsoleService.pressAnyKeyToContinue();
                                            }
                                            else{
                                                int indexItem;
                                                try {
                                                    indexItem = parseInt(indexDeleteItem) - 1;
                                                }
                                                catch (NumberFormatException e){
                                                    System.out.println("Optiune invalida!");
                                                    ConsoleService.pressAnyKeyToContinue();
                                                    continue;
                                                }
                                                if(indexItem >= MainService.getCurrentPlayer().getInventory().getItems().size() || indexItem < 0){
                                                    System.out.println("Optiune invalida!");
                                                    ConsoleService.pressAnyKeyToContinue();
                                                }
                                                else{
                                                    MainService.removeItem(indexItem);
                                                    System.out.println("item-ul a fost eliminat!");
                                                    ConsoleService.pressAnyKeyToContinue();
                                                }
                                            }
                                        }
                                        else if(inputInventoryMenu.equals("7")) {
                                            ConsoleService.clearScreen();
                                            MainService.useItem();
                                            ConsoleService.pressAnyKeyToContinue();
                                        }
                                        else{
                                            if(!Objects.equals(inputInventoryMenu, "0"))
                                            {
                                                System.out.println("Optiune invalida!");
                                                ConsoleService.pressAnyKeyToContinue();
                                            }
                                        }

                                    }while(!inputInventoryMenu.equals("0"));

                                }
                                else if(inputPlayerMenu.equals("2")) {
                                    ConsoleService.clearScreen();
                                    MainService.openRecipeBook();
                                    ConsoleService.pressAnyKeyToContinue();
                                }
                                else if(inputPlayerMenu.equals("3")){
                                    ConsoleService.clearScreen();
                                    MainService.showExistingBlocksList();
                                    System.out.println("Introduceti numarul block-ului pe care doriti sa il spargeti: ");
                                    String inputBreakBlock = scanner.nextLine();
                                    if(!inputBreakBlock.matches("[0-9]+")) {
                                        System.out.println("Optiune invalida!");
                                        ConsoleService.pressAnyKeyToContinue();
                                    }
                                    else{
                                        int indexBlock;
                                        try{
                                            indexBlock = parseInt(inputBreakBlock) - 1;
                                        }
                                        catch (NumberFormatException e){
                                            System.out.println("Optiune invalida!");
                                            ConsoleService.pressAnyKeyToContinue();
                                            continue;
                                        }
                                        if(indexBlock >= MainService.getExistingBlocksList().size() || indexBlock < 0){
                                            System.out.println("Optiune invalida!");
                                            ConsoleService.pressAnyKeyToContinue();
                                        }
                                        else{
                                            MainService.breakBlock(indexBlock);
                                            System.out.println("*Lovesti block-ul cu putere...*");
                                            try{
                                                Thread.sleep(3000);
                                            }
                                            catch (InterruptedException e){
                                                e.printStackTrace();
                                            }
                                            System.out.println("*Zgomote de block spart*");
                                            try{
                                                Thread.sleep(500);
                                            }
                                            catch (InterruptedException e){
                                                e.printStackTrace();
                                            }
                                            System.out.println("Block-ul a fost spart!");
                                            if(MainService.getExistingBlocksList().size() < numberOfBlocksToGenerate)
                                                MainService.generateOneRandomBlock();
                                            ConsoleService.pressAnyKeyToContinue();
                                        }
                                    }

                                }
                                else{
                                    if(!Objects.equals(inputPlayerMenu, "0"))
                                    {
                                        System.out.println("Optiune invalida!");
                                        ConsoleService.pressAnyKeyToContinue();
                                    }
                                }
                            }while(!inputPlayerMenu.equals("0"));
                        }

                    }

                }
                else if(Objects.equals(input, "3")){
                    ConsoleService.clearScreen();
                    if(MainService.getPlayerList().size() == 0){
                        System.out.println("Nu exista jucatori!");
                        ConsoleService.pressAnyKeyToContinue();
                    }
                    else{
                        MainService.showPlayerList();
                        System.out.println("Introduceti numarul jucatorului pe care doriti sa il stergeti: ");
                        String inputDeletePlayer = scanner.nextLine();
                        if(!inputDeletePlayer.matches("[0-9]+")) {
                            System.out.println("Optiune invalida!");
                            ConsoleService.pressAnyKeyToContinue();
                        }
                        else{
                            int indexPlayer;
                            try{
                                indexPlayer = parseInt(inputDeletePlayer) - 1;
                            }
                            catch (NumberFormatException e){
                                System.out.println("Optiune invalida!");
                                ConsoleService.pressAnyKeyToContinue();
                                continue;
                            }
                            if(indexPlayer >= MainService.getPlayerList().size() || indexPlayer < 0){
                                System.out.println("Optiune invalida!");
                                ConsoleService.pressAnyKeyToContinue();
                            }
                            else{
                                MainService.removePlayer(indexPlayer);
                                System.out.println("Jucatorul a fost sters!");
                                ConsoleService.pressAnyKeyToContinue();
                            }
                        }
                    }

                }
                else if(Objects.equals(input, "4")){
                    MainService.saveGame();
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

}
