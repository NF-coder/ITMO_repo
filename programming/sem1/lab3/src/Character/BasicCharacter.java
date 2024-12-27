package src.Character;

import src.Character.Actions.*;
import src.Character.CharacterMethods.CharacterCloth;
import src.Character.Actions.StepsEnums.StepStatus;
import src.Character.CharacterMethods.CharacterEnergy;
import src.Character.CharacterMethods.CharacterName;
import src.IBasicObj;
import src.Locations.FieldMethods.FieldLenght;
import src.Locations.LocationsEnums.GroundType;
import src.Random.RandomWrapper;
import src.Character.CharacterMethods.CharacterLocation;

import java.util.Objects;

public class BasicCharacter implements IBasicObj {
    private final int id;
    public final RandomWrapper rnd = new RandomWrapper();

    // methods
    public final CharacterCloth characterCloth = new CharacterCloth();
    public final CharacterEnergy characterEnergy = new CharacterEnergy();
    public final CharacterName characterName = new CharacterName();
    public final CharacterLocation characterLocation = new CharacterLocation();

    // actions
    public final MakeSteps makeSteps = new MakeSteps(characterEnergy, characterName);
    public final TellBadWords tellBadWords = new TellBadWords(characterName);
    public final BitePotato bitePotato = new BitePotato(rnd);
    public final ThrowPotatoes throwPotatoes = new ThrowPotatoes(characterCloth, characterName);
    public final CheckIfClothBroken checkIfClothBroken = new CheckIfClothBroken(characterCloth);
    public final ClaimPotatoes claimPotatoes = new ClaimPotatoes(characterCloth, characterName);
    public final SmellFood smellFood = new SmellFood(rnd);
    public final EnjoyGrass enjoyGrass = new EnjoyGrass();
    public final GoFurther goFurther = new GoFurther();
    public final BecomeTired becomeTired = new BecomeTired();
    public final SleepOnGround sleepOnGround = new SleepOnGround();
    public final LeaveField leaveField = new LeaveField(characterName);
    public final ReclaimPotatoes reclaimPotatoes = new ReclaimPotatoes(rnd, characterEnergy, characterCloth, goFurther);
    public final GetTiredOfWalk getTiredOfWalk = new GetTiredOfWalk();
    public final SavePotatoes savePotatoes = new SavePotatoes(characterCloth, characterName);


    // init
    public BasicCharacter(String name) {
        this.characterName.setName(name);
        this.id = 1;
    }

    // Actions methods
    public StepStatus makeStep(){
        return this.makeSteps.makeStep(
                characterCloth.getCloth()
        );
    }


    // IBasicObj Implementation
    public String getName(){ return this.characterName.getName(); }
    public int getId(){ return this.id; }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.characterEnergy.getEnergy(), characterCloth.getCloth().getPotatoesCount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicCharacter character = (BasicCharacter) o;
        return this.getName().equals(character.getName()) &&
                characterCloth.getCloth().equals(character.characterCloth.getCloth()) &&
                this.characterEnergy.getEnergy() == character.characterEnergy.getEnergy();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name=" + this.getName() +
                ", energy=" + this.characterEnergy.getEnergy() +
                ", cloth=" + this.characterCloth.getCloth() +
                '}';
    }
}
