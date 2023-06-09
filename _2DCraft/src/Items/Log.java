package Items;

import Services.MainService;

public class Log extends Item{
    public Log(int id, String name) {
            super(id, name);
        }

    @Override
    public void useItem(){
        MainService.getExistingBlocksList().add(new Blocks.Log(14, name, 100, "log", 0, 0));
        MainService.getCurrentPlayer().getInventory().setEquippedItem(null);
    }
}
