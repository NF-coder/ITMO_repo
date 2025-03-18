package objects.parsers.InvokersParsers.ObjectsParsers;

import core.Engine;
import objects.enums.EnumInterface;
import textWorkers.invokers.IInvoker;

public interface IParser<T> {
    public IInvoker invoker = Engine.getActiveInvoker();
    public T run() throws Exception;
}
