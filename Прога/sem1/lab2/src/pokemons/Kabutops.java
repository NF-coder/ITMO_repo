package src.pokemons;

import ru.ifmo.se.pokemon.Type;
import src.moves.phys.XScissor;
import src.moves.spec.AncientPower;
import src.moves.spec.IceBeam;
import src.moves.stat.RockPolish;

// https://pokemondb.net/pokedex/kabutops
public final class Kabutops extends Kabuto {
    public Kabutops(){
        this("Безымянный Kabutops",1);// 40
    }

    public Kabutops(String name, int level){
        super(name, level);
        this.setType(Type.ROCK, Type.WATER);
        this.setStats(60, 115, 105, 65, 70, 80);
        this.setMove(new RockPolish(), new AncientPower(), new IceBeam(), new XScissor());
    }
}
