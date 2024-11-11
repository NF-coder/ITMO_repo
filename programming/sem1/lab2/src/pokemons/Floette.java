package src.pokemons;

import ru.ifmo.se.pokemon.Type;
import src.moves.phys.Tackle;
import src.moves.spec.MagicalLeaf;
import src.moves.stat.DoubleTeam;

// https://pokemondb.net/pokedex/floette
public class Floette extends Flabebe {
    public Floette(){
        this("Безымянный Floette",1); // 19?
    }

    public Floette(String name, int level){
        super(name, level);
        this.setType(Type.FAIRY);
        this.setStats(54, 45, 47, 75, 98, 52);
        this.setMove(new MagicalLeaf(), new DoubleTeam(), new Tackle());
    }
}
