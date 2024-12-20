package src.Character;

public class Skuperfild extends BasicCharacter{
    public Skuperfild(){
        super("Скуперфильд");
    }

    public void throwPotatoes(){
        this.setPotatoes(0);
        System.out.println(this.getName() + " швырнул картофель в сторону.");
    }

}
