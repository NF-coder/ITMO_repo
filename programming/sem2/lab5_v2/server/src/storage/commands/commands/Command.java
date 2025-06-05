package storage.commands.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import storage.collection.drivers.IStructDriver;

import java.util.HashMap;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class Command implements Supplier<JSONObject> {
    public String NAME;
    protected IStructDriver driver;
    protected HashMap<String,String> args;
    protected final Logger logger = LogManager.getLogger();

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
    public abstract JSONObject call() throws Exception;

    /**
     * Вызов команды
     * @return Результат работы команды
     */
    public JSONObject get(){
        System.out.println("Command Abstract class called");
        JSONObject jo = new JSONObject();
        try {
            JSONObject result = this.call();

            jo.put("status", String.valueOf(Status.OK));
            jo.put("result", Objects.requireNonNullElse(result, "successfully completed"));

            System.out.println(jo);

            return jo;
        }
        catch (Exception e) {
            jo.put("status", String.valueOf(Status.ERROR));
            jo.put("description", e.getMessage());
            return jo;
        }
    }
}