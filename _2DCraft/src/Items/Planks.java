package Items;

import Services.MainService;

public class Planks extends Item{

    public Planks(double id, String name) {
        super(id, name);
    }

    @Override
    public void useItem(){
        MainService.getExistingBlocksList().add(new Blocks.Planks(12, name, 100, "planks", 0, 0));
        MainService.getCurrentPlayer().getInventory().setEquippedItem(null);
    }
}

