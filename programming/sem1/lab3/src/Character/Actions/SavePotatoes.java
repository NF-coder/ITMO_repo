package src.Character.Actions;

import src.Character.CharacterMethods.CharacterCloth;
import src.Character.CharacterMethods.CharacterName;
import src.Locations.LocationsEnums.GroundType;

public class SavePotatoes {
    private final CharacterCloth cloth;
    private final CharacterName name;

    public SavePotatoes(CharacterCloth cloth, CharacterName name) {
        this.cloth = cloth;
        this.name = name;
    }

    public void saveUnusefulPotatoes(GroundType groundType, int potatoesCnt){
        System.out.print("Сообразив, однако, что никто не стал бы выращивать совершенно бесполезных плодов, он сунул вытащенные из " +
                groundType +
                " " +
                potatoesCnt +
                " картофелин в карман "+
                this.name.getName() +
                ". "
        );
    }
    public void saveUsefulPotatoes(GroundType groundType, int potatoesCnt){
        System.out.print(", поэтому он сунул вытащенные из " +
                groundType +
                " " +
                potatoesCnt +
                " картофелин в карман " +
                this.cloth.getCloth().getName() +
                ". "
        );
    }
    public void savePotatoesFastly(){
        System.out.print("Затем он быстро суёт их в карман " +this.cloth.getCloth().getName() + ". ");
    }
}
