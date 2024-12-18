package src.Character;

public class Skuperfild extends BasicCharacter{
    public int potatoesCount;
    public Skuperfild(){
        super("Скуперфильд");
    }

    public void throwPotatoes(){
        potatoesCount = 0;
        System.out.println(this.getName() + " швырнул картофель в сторону.");
    }

    public void makeStep(){
        makeEnergyStep();
        this.cloth.stepPotatoes();
    }
}
