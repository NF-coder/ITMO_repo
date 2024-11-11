package src.pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import src.moves.spec.AncientPower;
import src.moves.spec.IceBeam;
import src.moves.stat.RockPolish;

// https://pokemondb.net/pokedex/kabuto
public class Kabuto extends Pokemon {
    public Kabuto(){
        this("Безымянный Kabuto",1);
    }

    public Kabuto(String name, int level){
        super(name, level);
        this.setType(Type.ROCK, Type.WATER);
        this.setStats(30, 80, 90, 55, 45, 55);
        this.setMove(new RockPolish(), new AncientPower(), new IceBeam());
    }
}
