package src.moves.spec;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/ancient-power
public final class AncientPower extends SpecialMove {
    final Stat[] EffectStats = {Stat.ATTACK, Stat.DEFENSE, Stat.SPECIAL_ATTACK, Stat.SPECIAL_DEFENSE, Stat.SPEED};

    public AncientPower(){
        super(Type.ROCK, 60, 100);
    }

    @Override
    protected String describe(){
        return "использует атаку Ancient Power (SpecialMove)";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon){
        if (1./10. > Math.random()) {
            System.out.println("Крит. удар!");
            for (Stat pokemonStats : EffectStats) { 
                pokemon.addEffect(
                    new Effect().chance(1.).stat(pokemonStats, 1)
                );
            }
        }
    }
}
