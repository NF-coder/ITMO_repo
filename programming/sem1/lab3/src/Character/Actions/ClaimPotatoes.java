package src.Character.Actions;

import src.Character.Actions.Exceptons.NegativePotatoesException;
import src.Character.CharacterMethods.CharacterCloth;
import src.Character.CharacterMethods.CharacterName;
import src.Locations.LocationsEnums.GroundType;

public class ClaimPotatoes {
    private final CharacterCloth cloth;
    private final CharacterName name;
    public ClaimPotatoes(CharacterCloth cloth, CharacterName name) {
        this.cloth = cloth;
        this.name = name;
    }

    public void claimPotatoes(int potatoesCnt, GroundType groundType) {
        try {
            this.cloth.getCloth().setPotatoes(potatoesCnt);
            System.out.print(name.getName() +
                    " достаёт " +
                    potatoesCnt +
                    " клубней из " +
                    groundType +
                    ". "
            );
        }
        catch (NegativePotatoesException e){
            System.out.println(name.getName() + " не подобрал ни одной картофелины.");
        }
    }
}
