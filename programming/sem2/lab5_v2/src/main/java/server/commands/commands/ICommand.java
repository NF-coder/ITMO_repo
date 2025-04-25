package server.commands.commands;

import server.storage.drivers.IStructDriver;
import server.storage.objects.exceptions.UnacceptableValue;

public interface ICommand<T, N> {
    public N run(IStructDriver driver, T args) throws Exception;
    public String getName();
}