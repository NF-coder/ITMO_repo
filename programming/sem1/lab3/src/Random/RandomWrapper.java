package src.Random;


import src.Clothes.ClothesEnum;

import java.util.Random;

public class RandomWrapper extends Random{
    public final Random rnd = new Random();

    /*public <T> String enumRandomPick(T enumItem){
        int pick = rnd.nextInt(enumItem.values().length);
        return enumItem.values()[pick];
    }*/
}
