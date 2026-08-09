package src.Character.Actions;

import src.Random.RandomWrapper;

public class SmellFood {
    private final RandomWrapper rnd;
    public SmellFood(RandomWrapper rnd) {
        this.rnd = rnd;
    }

    public void smellFood(){
        System.out.print("и в тот же момент ощутил доносившийся откуда-то запах " +
                rnd.randomizeSmell() +
                ". От этого запаха на него словно повеяло теплом и домашним уютом.");
    }
}
