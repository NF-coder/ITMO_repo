package src.moves.phys;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/tackle
public final class Tackle extends PhysicalMove{
    public Tackle(){
        super(Type.NORMAL, 40, 100);
    }

    @Override
    protected String describe(){
        return "использует атаку Tackle (PhysicalMove)";
    }
}
