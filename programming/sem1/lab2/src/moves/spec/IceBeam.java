package src.moves.spec;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/ice-beam
public final class IceBeam extends SpecialMove{
    public IceBeam(){
        super(Type.ICE, 90, 100);
    }

    @Override
    protected String describe(){
        return "использует атаку Ice Beam (SpecialMove)";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon){

        // Magma Armor ability? Substitute?
        if (!pokemon.hasType(Type.ICE)){
            pokemon.setCondition(
                new Effect().chance(0.1).condition(Status.FREEZE)
            );
        }
    }
}
