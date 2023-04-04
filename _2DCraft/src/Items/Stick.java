package Items;

public class Stick extends Item{

    public Stick(double id, String name) {
        super(id, name);
    }

    @Override
    public void useItem(){
        System.out.println("Nu s-a intamplat nimic...");
    }
}

