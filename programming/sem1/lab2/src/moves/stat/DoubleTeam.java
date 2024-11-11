package src.moves.stat;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/double-team
public final class DoubleTeam extends StatusMove{
    public DoubleTeam(){
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon){
         pokemon.addEffect(
            new Effect().chance(1.).stat(Stat.EVASION, 1)
        );
    }

    @Override
    protected String describe(){
        return "использует атаку Double Team (StatusMove)";
    }
}
