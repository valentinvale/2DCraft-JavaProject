package Items;

import Services.MainService;

public class Leaves extends Item{
    public Leaves(double id, String name) {
                super(id, name);
            }

    @Override
    public void useItem(){
        MainService.getExistingBlocksList().add(new Blocks.Leaves(12, name, 100, "leaves", 0, 0));

    }
}
