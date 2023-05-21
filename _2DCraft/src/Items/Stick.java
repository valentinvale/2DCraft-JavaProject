package Items;

public class Stick extends Item{

    public Stick(int id, String name) {
        super(id, name);
    }

    @Override
    public void useItem(){
        System.out.println("Nu s-a intamplat nimic...");
    }
}

