package src.moves.stat;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/rock-polish
public final class RockPolish extends StatusMove {
    public RockPolish(){
        super(Type.ROCK, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon){
         pokemon.addEffect(
            new Effect().chance(1.).stat(Stat.SPEED, 2)
        );
    }

    @Override
    protected String describe(){
        return "использует атаку Rock Polish (StatusMove)";
    }

}
