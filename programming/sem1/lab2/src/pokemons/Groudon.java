package src.pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import src.moves.phys.HammerArm;
import src.moves.phys.StoneEdge;
import src.moves.spec.Overheat;
import src.moves.stat.RockPolish;

// https://pokemondb.net/pokedex/groudon
public final class Groudon extends Pokemon{
    public Groudon(){
        this("Безымянный Groudon",1);
    }

    public Groudon(String name, int level){
        super(name, level);
        this.setType(Type.GROUND);
        this.setStats(100, 150, 140, 100, 90, 90);
        this.setMove(new Overheat(), new HammerArm(), new StoneEdge(), new RockPolish());
    }
}