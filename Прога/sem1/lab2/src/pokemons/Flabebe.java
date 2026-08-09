package src.pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import src.moves.spec.MagicalLeaf;
import src.moves.stat.DoubleTeam;

// https://pokemondb.net/pokedex/flabebe
public class Flabebe extends Pokemon {
    public Flabebe(){
        this("Безымянный Flabebe",1);
    }

    public Flabebe(String name, int level){
        super(name, level);
        this.setType(Type.FAIRY);
        this.setStats(44, 38, 39, 61, 79, 42);
        this.setMove(new MagicalLeaf(), new DoubleTeam());
    }
}
