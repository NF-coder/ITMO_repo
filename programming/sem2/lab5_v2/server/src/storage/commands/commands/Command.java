package storage.commands.commands;

import storage.collection.drivers.IStructDriver;

import java.util.HashMap;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class Command implements Supplier<HashMap<String,String>> {
    public String NAME;
    protected IStructDriver driver;
    protected HashMap<String,String> args;

    protected Command(String name) {
        this.NAME = name;
    }
    /**
     * Передача аргументов и драйвера доступа к структуре
     * @param args аргументы
     * @param driver драйвер коллекции
     */
    public void setData(HashMap<String, String> args,  IStructDriver driver) {
        this.args = args;
        this.driver = driver;
    }

    /**
     * Получение имени команды
     */
    public String getName() {
        return this.NAME;
    }

    /**
     * @hidden
     * Вызов команды (НЕ ВЫЗЫВАТЬ НАПРЯМУЮ!)
     * @return Результат работы команды
     * @throws Exception любое необработанное исключение, полученное в результате исполнения
     */
    public abstract String call() throws Exception;

    /**
     * Вызов команды
     * @return Результат работы команды
     */
    public HashMap<String,String> get(){
        try {
            String result = this.call();
            HashMap<String, String> h = new HashMap<>();

            h.put("status", String.valueOf(Status.OK));
            h.put("result", Objects.requireNonNullElse(result, "successfully completed"));

            return h;
        }
        catch (Exception e) {
            HashMap<String,String> h = new HashMap<>();

            h.put("status", String.valueOf(Status.ERROR));
            h.put("description", e.getMessage());
            return h;
        }
    }
}