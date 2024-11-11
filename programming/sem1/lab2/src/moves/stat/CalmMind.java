package src.moves.stat;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/calm-mind
public final class CalmMind extends SpecialMove{
    public CalmMind(){
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon){
        pokemon.addEffect(
            new Effect().chance(1.).stat(Stat.SPECIAL_ATTACK, 1)
        );
        pokemon.addEffect(
            new Effect().chance(1.).stat(Stat.SPECIAL_DEFENSE, 1)
        );
    }

    @Override
    protected String describe(){
        return "использует атаку Calm Mind (StatusMove)";
    }
}
