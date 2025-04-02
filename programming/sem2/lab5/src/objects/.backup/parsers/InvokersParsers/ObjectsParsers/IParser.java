package objects.parsers.InvokersParsers.ObjectsParsers;

import core.Engine;
import textWorkers.invokers.IInvoker;

public interface IParser<T> {
    public IInvoker invoker = Engine.getActiveInvoker();
    public T run() throws Exception;
}
