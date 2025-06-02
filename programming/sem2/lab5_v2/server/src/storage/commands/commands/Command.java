package storage.commands.commands;

import org.json.JSONObject;
import storage.collection.drivers.IStructDriver;

import java.util.HashMap;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class Command implements Supplier<JSONObject> {
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
    public JSONObject get(){
        JSONObject jo = new JSONObject();
        try {
            String result = this.call();

            jo.put("status", String.valueOf(Status.OK));
            jo.put("result", Objects.requireNonNullElse(result, "successfully completed"));
            return jo;
        }
        catch (Exception e) {
            jo.put("status", String.valueOf(Status.ERROR));
            jo.put("description", e.getMessage());
            return jo;
        }
    }
}