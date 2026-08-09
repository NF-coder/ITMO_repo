package src.Character.Actions;

import src.Character.BasicCharacter;
import src.Random.RandomWrapper;

public class BitePotato {
    private final RandomWrapper rnd;
    public BitePotato(RandomWrapper rnd) {
        this.rnd = rnd;
    }

    public boolean bite(){
        System.out.print("Скуперфильд откусил кусочек и попробовал его разжевать.");
        final boolean isDelicious = this.rnd.randomizePotato().isDelicious();

        if (isDelicious) {
            System.out.print("Сырой картофель оказался весьма сносным");
        } else {
            System.out.print("Сырой картофель показался ему страшно невкусным, даже противным. ");
        }
        return isDelicious;
    }
}
