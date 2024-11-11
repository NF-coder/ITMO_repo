package src.moves.phys;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/stone-edge
public final class StoneEdge extends PhysicalMove {
    public StoneEdge(){
        super(Type.ROCK, 100, 80);
    }

    protected double calcCriticalHit(Pokemon pokemonAtt, Pokemon pokemonDef) {
        	if (1./8. > Math.random()) {
            		System.out.println("Крит. удар!");
            		return 2.0;
        	}
	       	else { return 1.0; }
	}

    @Override
    protected String describe(){
        return "использует атаку Stone Edge (PhysicalMove)";
    }
}
