package src.pokemons;

import ru.ifmo.se.pokemon.Type;
import src.moves.phys.Tackle;
import src.moves.spec.MagicalLeaf;
import src.moves.stat.CalmMind;
import src.moves.stat.DoubleTeam;

// https://pokemondb.net/pokedex/floette
public final class Florges extends Floette{
    public Florges(){
        this("Безымянный Florges",1); // ???
    }

    public Florges(String name, int level){
        super(name, level);
        this.setType(Type.FAIRY);
        this.setStats(78, 65, 68, 112, 154, 75);
        this.setMove(new MagicalLeaf(), new DoubleTeam(), new Tackle(), new CalmMind());
    }
}
