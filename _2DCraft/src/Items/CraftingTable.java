package Items;

import Services.MainService;

public class CraftingTable extends Item{
    public CraftingTable(double id, String name) {
                super(id, name);
            }

    @Override
    public void useItem(){
        MainService.getExistingBlocksList().add(new Blocks.CraftingTable(12, "Crafting Table", 100, "crafting_table", 0, 0));
    }

}
