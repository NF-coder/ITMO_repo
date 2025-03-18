package commands;

import core.Structure;

import java.util.HashMap;

public class AverageOfMetersAboveSeaLevel extends BasicCommand{
    public AverageOfMetersAboveSeaLevel(){
        super("average_of_meters_above_sea_level", "Выводит среднюю высоту над уровнем моря");
    }

    public final void execute(HashMap<String, String> args){
        Structure structure = new Structure();
        System.out.println(structure.averageOfMetersAboveSeaLevel());
    }
}
