package src.Clothes;

/*import src.IBasicObj;

public abstract class Cloth implements IBasicObj {
    private final int id;
    private final String name;
    private int potatoesCount;
    private final int stepIncriment;

    public Cloth(String name, int stepIncriment) {
        this.name = name;
        this.stepIncriment = stepIncriment;
        this.id = 0;
    }

    public void makeStep(){
        potatoesCount -= stepIncriment;
    }

    public String getName(){ return this.name; }
    public int getId(){ return this.id; }
}*/

public record Cloth(String name, int stepIncriment) { }
