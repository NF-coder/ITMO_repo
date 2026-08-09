package src;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;
import src.pokemons.Flabebe;
import src.pokemons.Floette;
import src.pokemons.Florges;
import src.pokemons.Groudon;
import src.pokemons.Kabuto;
import src.pokemons.Kabutops;

public class Main {
    public static void main(String[] args ){
        Battle battle = new Battle();
        
        Pokemon[] team1 =  {new Kabutops(), new Floette(), new Florges()};
        Pokemon[] team2 =  {new Kabuto(), new Groudon(), new Flabebe()};

        for (Pokemon pokemon : team1){ battle.addAlly(pokemon); }
        for (Pokemon pokemon : team2){ battle.addFoe(pokemon); }

        battle.go();
    }
}
