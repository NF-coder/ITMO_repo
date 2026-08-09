package src.moves.spec;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/overheat
public final class Overheat extends SpecialMove{ // final - can't be extended using this class
    public Overheat(){
        super(Type.FIRE, 130, 90);
    }

    @Override
    protected String describe(){
        return "использует атаку Overheat (SpecialMove)";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon){
        pokemon.addEffect(
            new Effect().chance(1.).stat(Stat.SPECIAL_ATTACK, -2)
        );
    }
}

