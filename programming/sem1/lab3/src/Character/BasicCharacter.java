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
    private final MakeSteps makeSteps = new MakeSteps(characterEnergy, characterName);
    private final TellBadWords tellBadWords = new TellBadWords(characterName);
    private final BitePotato bitePotato = new BitePotato(rnd);
    private final ThrowPotatoes throwPotatoes = new ThrowPotatoes(characterCloth, characterName);
    private final CheckIfClothBroken checkIfClothBroken = new CheckIfClothBroken(characterCloth);
    private final ClaimPotatoes claimPotatoes = new ClaimPotatoes(characterCloth, characterName);
    private final SmellFood smellFood = new SmellFood(rnd);
    private final EnjoyGrass enjoyGrass = new EnjoyGrass();
    private final GoFurther goFurther = new GoFurther();
    private final BecomeTired becomeTired = new BecomeTired();
    private final SleepOnGround sleepOnGround = new SleepOnGround();
    private final LeaveField leaveField = new LeaveField(characterName);
    private final ReclaimPotatoes reclaimPotatoes = new ReclaimPotatoes(rnd, characterEnergy, characterCloth, goFurther);
    private final GetTiredOfWalk getTiredOfWalk = new GetTiredOfWalk();
    private final SavePotatoes savePotatoes = new SavePotatoes(characterCloth, characterName);


    // init
    public BasicCharacter(String name) {
        this.characterName.setName(name);
        this.id = 1;
    }

    // Actions methods
    public void throwPotatoes(){ this.throwPotatoes.throwPotatoes();}
    public void checkIfClothBroken(){ this.checkIfClothBroken.checkIfClothBroken(); }
    public void claimPotatoes(int potatoesCnt, GroundType groundType){
        this.claimPotatoes.claimPotatoes(potatoesCnt, groundType);
    }
    public boolean bite(){ return bitePotato.bite(); }
    public StepStatus makeStep(){
        return this.makeSteps.makeStep(
                characterCloth.getCloth()
        );
    }
    public StepStatus makeStepAfterReclaim(){ return this.makeSteps.makeStepAfterReclaim(); }
    public void tellBadWords(){ this.tellBadWords.tellBadWords(); }
    public void smellFood(){ this.smellFood.smellFood(); }
    public void enjoyGrass(){ this.enjoyGrass.enjoyGrass(); }
    public void goFurther(){ this.goFurther.goFurther(); }
    public void becomeTired(){ this.becomeTired.becomeTired(); }
    public void sleepOnGround(){ this.sleepOnGround.sleepOnGround(); }
    public void leaveField(){ this.leaveField.leaveField(); }
    public void reclaimPotatoes(FieldLenght fieldLenght){ this.reclaimPotatoes.reclaimPotatoes(fieldLenght); }
    public void getTiredOfWalk(GroundType groundType){this.getTiredOfWalk.getTiredOfWalk(groundType);}
    public void saveUnusefulPotatoes(GroundType groundType, int potatoesCnt){ savePotatoes.saveUnusefulPotatoes(groundType, potatoesCnt); }
    public void saveUsefulPotatoes(GroundType groundType, int potatoesCnt){ savePotatoes.saveUsefulPotatoes(groundType, potatoesCnt); }
    public void savePotatoesFastly(){ savePotatoes.savePotatoesFastly(); }


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
