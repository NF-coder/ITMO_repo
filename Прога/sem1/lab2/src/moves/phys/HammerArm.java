package src.moves.phys;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/hammer-arm
public final class HammerArm extends PhysicalMove{
    public HammerArm(){
        super(Type.FIGHTING, 100, 90);
    }

    @Override
    protected String describe(){
        return "использует атаку Hammer Arm (PhysicalMove)";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon){
        pokemon.addEffect(
            new Effect().chance(1.).stat(Stat.SPEED, -1)
        );
    }  // javac -d bin -classpath ./lib/Pokemons.jar -sourcepath ./src/moves/stat/*.java;./src/moves/phys/*.java;./src/moves/spec/*.java;./src/pokemons/*.java  ./src/Main.java
}