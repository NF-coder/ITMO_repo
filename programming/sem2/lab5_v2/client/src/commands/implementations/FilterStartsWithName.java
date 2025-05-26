package commands.implementations;

import commands.BasicCommand;
import core.Engine;
import shared.objects.NetworkRequestDTO;

import java.util.HashMap;
import java.util.function.Consumer;

public class FilterStartsWithName extends BasicCommand {
    public FilterStartsWithName(Consumer<HashMap<String,String>> outHandler) {
        super("filter_starts_with_name", "Calculates average meters above the sea." +
                "\n\t Example: filter_starts_with_name -name_beginning [String] ",
                outHandler
        );
    }

    @Override
    public final void execute(HashMap<String, String> args, Engine engine) throws Exception{
        engine.networkManager.send(
                new NetworkRequestDTO(
                        "filter_starts_with_name",
                        args
                )
        );
        this.getOutHandler().accept(
                engine.networkManager.receive().result()
        );
    }
}
