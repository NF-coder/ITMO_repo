package src.moves.spec;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/magical-leaf
/*
 * However, it will not hit Pokémon during the invulnerable stage of
 * Bounce, Dig, Dive, Fly, Phantom Force, Shadow Force or Sky Drop.
 */
public final class MagicalLeaf extends SpecialMove{
    public MagicalLeaf(){
        super(Type.GRASS, 60, Double.POSITIVE_INFINITY); // inf accuracy?
    }

    @Override
    protected String describe(){
        return "использует атаку Magical Leaf (SpecialMove)";
    }
}
