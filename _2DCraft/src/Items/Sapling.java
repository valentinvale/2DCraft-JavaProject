package Items;

public class Sapling extends Item{

    public Sapling(double id, String name) {
        super(id, name);
    }
    @Override
    public void useItem(){
        System.out.println("Inca nu poti planta un sapling");
    }
}
