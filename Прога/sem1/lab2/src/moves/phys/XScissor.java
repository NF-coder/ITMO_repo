package src.moves.phys;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/x-scissor
public final class XScissor extends PhysicalMove {
    public XScissor(){
        super(Type.BUG, 80, 100);
    }

    @Override
    protected String describe(){
        return "использует атаку X-Scissor (PhysicalMove)";
    }
}
