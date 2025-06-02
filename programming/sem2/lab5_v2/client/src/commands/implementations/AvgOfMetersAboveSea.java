package commands.implementations;

import commands.BasicCommand;
import core.Engine;
import org.json.JSONObject;
import shared.objects.NetworkRequestDTO;

import java.util.HashMap;
import java.util.function.Consumer;

public class AvgOfMetersAboveSea extends BasicCommand {
    public AvgOfMetersAboveSea(Consumer<JSONObject> outHandler) {
        super("average_of_meters_above_sea_level", "Calculates average meters above the sea.", outHandler);
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "average_of_meters_above_sea_level",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
