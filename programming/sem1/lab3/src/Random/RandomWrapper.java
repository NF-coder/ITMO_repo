package src.Random;


import src.Clothes.ClothesEnum;
import src.Locations.LocationsEnums.SmellType;
import src.Locations.LocationsEnums.GroundType;
import src.Objects.Potato;
import src.Clothes.Cloth;

import java.util.Random;

public final class RandomWrapper extends Random{
    private final Random rnd = new Random();

    public int randomizePotatoes(){
        return this.rnd.nextInt(1, 15);
    }

    public GroundType randomizeGroundType(){
        final int pickGround = rnd.nextInt(GroundType.values().length);
        return GroundType.values()[pickGround];
    }

    public Potato randomizePotato(){
        return new Potato(rnd.nextBoolean());
    }

    public Cloth randomizeCloth(){
        int pickCloth = rnd.nextInt(ClothesEnum.values().length);
        final int stepIncriment;
        if (rnd.nextFloat(0,1) < 0.7f){
            stepIncriment = rnd.nextInt(1,3);
        } else {
            stepIncriment = 0;
        }
        return ClothesEnum.values()[pickCloth].toCloth(stepIncriment);
    }

    public int randomizeFieldLenght(){ return rnd.nextInt(1,5); }
    public int randomizeEnergy(int fieldLenght, int potatoesCnt){
        return rnd.nextInt(0,fieldLenght+potatoesCnt/2);
    }
    public int ramdomizePotatoesReclamation(int energy, int potatoesCnt){
        return  rnd.nextInt(0, Math.min(energy, potatoesCnt/2));
    }

    public SmellType randomizeSmell(){
        int pickSmell = rnd.nextInt(GroundType.values().length);
        return SmellType.values()[pickSmell];
    }

    public boolean randomizeCanSmell(){
        return rnd.nextFloat(0,1) < 0.7f;
    }
}
