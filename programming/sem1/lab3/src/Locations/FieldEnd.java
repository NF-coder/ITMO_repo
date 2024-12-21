package src.Locations;

import src.Character.BasicCharacter;
import src.Locations.FieldEndPkg.SmellType;
import src.Locations.FieldStartPkg.GroundType;

public class FieldEnd extends Location{
    private final int totalLenght;
    public FieldEnd(BasicCharacter character, int totalLenght) {
        super("FieldEnd", character);
        this.totalLenght = totalLenght;
    }

    public Location run(){
        BasicCharacter character = this.getCharacter();
        System.out.print(character.getName() +
                " на все лады проклинал коротышек, вздумавших, словно ему назло, взрыхлить вокруг землю и насадить на его пути все эти кустики. "
        );

        if (character.getEnergy() < this.totalLenght){
            System.out.print("В какой-то момент он окончательно выбился из сил, сел посреди поля и стал ожидать чего-то, сам не зная чего. ");
        } else if (character.getEnergy() == this.totalLenght) {
            System.out.print("Он еле-еле смог доползти до конца поля и ступив на твёрдую землю он сразу лёг в траву и уснул.");
        } else {
            System.out.print("Как и следовало ожидать, ему все же удалось в конце концов добраться до края картофельного поля.\n" +
                    "Выбравшись на твердую почву, Скуперфильд облегченно вздохнул "
            );

            if (rnd.nextFloat(0,1) < 0.7f){
                int pickSmell = rnd.nextInt(GroundType.values().length);
                System.out.print("и в тот же момент ощутил доносившийся откуда-то запах " +
                        SmellType.values()[pickSmell] +
                        ". От этого запаха на него словно повеяло теплом и домашним уютом. \n");
            } else {
                System.out.print(". Он ещё никогда не был так рад ощущать траву под ногами.");
            }
        }

        return null;
    }
}
