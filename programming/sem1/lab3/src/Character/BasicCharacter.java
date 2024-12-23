package src.Character;

import src.Character.Exceptons.NegativeEnergyException;
import src.Character.Exceptons.NegativePotatoesException;
import src.Character.StepsEnums.StepStatus;
import src.Character.StepsEnums.StepStatusAfterReclaim;
import src.Clothes.Cloth;
import src.IBasicObj;
import src.Locations.LocationsEnums.GroundType;
import src.Random.RandomWrapper;

import java.util.Objects;

public class BasicCharacter implements IBasicObj {
    private final String name;
    private final int id;
    protected Cloth cloth;
    private int energy;
    private final RandomWrapper rnd = new RandomWrapper();

    // init
    public BasicCharacter(String name) {
        this.name = name;
        this.id = 1;
    }

    // Cloth getter/setter
    public void setCloth(Cloth cloth){
        this.cloth = cloth;
    }
    public Cloth getCloth(){ return this.cloth; }

    // Energy getter/setter
    public void setEnergy(int energy){
        this.energy = energy;
    }
    public int getEnergy(){ return this.energy; }
    public void energyStepIncriment() throws NegativeEnergyException{
        if (energy == 0) {throw new NegativeEnergyException();}
        this.setEnergy(this.getEnergy()-1);
    }

    // IBasicObj getters
    public String getName(){ return this.name; }
    public int getId(){ return this.id; }


    // set potatoes to 0 and print text
    public void throwPotatoes(){
        try {
            this.getCloth().setPotatoes(0);
            System.out.print(this.getName() + " швырнул картофель в сторону. ");
        }
        catch (NegativePotatoesException e){
            System.out.println("Error: check your code, idiot!");
        }
    }

    // check if cloth broken
    public void checkIfClothBroken(){
        if (this.getCloth().getStepIncrement() != 0) {
            System.out.print("Однако он оказался дырявым и при каждом шаге вываливалось " + cloth.getStepIncrement() + " клубней. ");
        }
    }

    // claim potatoes
    public void claimPotatoes(int potatoesCnt, GroundType groundType){
        try {
            this.getCloth().setPotatoes(potatoesCnt);
            System.out.print(this.name +
                    " достаёт " +
                    potatoesCnt +
                    " клубней из " +
                    groundType +
                    ". "
            );
        }
        catch (NegativePotatoesException e){
            System.out.println(this.getName() + " не подобрал ни одной картофелины.");
        }
    }

    // bite potato
    public boolean bite(){
        System.out.print("Скуперфильд откусил кусочек и попробовал его разжевать.");
        final boolean isDelicious = rnd.randomizePotato().isDelicious();

        if (isDelicious) {
            System.out.print("Сырой картофель оказался весьма сносным");
        } else {
            System.out.print("Сырой картофель показался ему страшно невкусным, даже противным. ");
        }
        return isDelicious;
    }

    // make step (potatoes + energy)
    public StepStatus makeStep() {
        try {
            this.getCloth().makeStep();
        }
        catch (NegativePotatoesException e){
            System.out.print("В какой-то момент " +
                    this.getName() +
                    " ощутил необычайную лёгкость и решил проверить карманы. Он обнаружил, что из прорех вывалился весь картофель, "
            );
            return StepStatus.NOT_ENOUGH_POTATOES;
        }

        try {
            this.energyStepIncriment();
        }
        catch (NegativeEnergyException e){
            System.out.print("В какой-то момент он окончательно выбился из сил, сел посреди поля и стал ожидать чего-то, сам не зная чего. ");
            return StepStatus.NOT_ENOUGH_ENERGY;
        }

        return StepStatus.OK;
    }

    public void tellBadWords(){
        System.out.print(
                this.getName() +
                " на все лады проклинал коротышек, вздумавших, словно ему назло, взрыхлить вокруг землю и насадить на его пути все эти кустики. "
        );
    }

    // make step (energy)
    public StepStatusAfterReclaim makeStepAfterReclaim(){
        try {
            this.energyStepIncriment();
        }
        catch (NegativeEnergyException e){
            System.out.print("В какой-то момент он окончательно выбился из сил, сел посреди поля и стал ожидать чего-то, сам не зная чего. ");
            return StepStatusAfterReclaim.TIRED;
        }

        if (this.getEnergy() == 0) return StepStatusAfterReclaim.LAST_STEP;
        return StepStatusAfterReclaim.OK;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getEnergy(), this.getCloth().getPotatoesCount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicCharacter character = (BasicCharacter) o;
        return this.getName().equals(character.getName()) &&
                this.getCloth().equals(character.getCloth()) &&
                this.getEnergy() == character.getEnergy();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name=" + this.getName() +
                ", energy=" + this.getEnergy() +
                ", cloth=" + this.getCloth() +
                '}';
    }
}
