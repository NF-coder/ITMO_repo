package commands;

import core.Engine;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * Шаблон команды
 */
public abstract class BasicCommand {
    private String name;
    private String info;
    private final Consumer<JSONObject> outputHandler;

    /**
     * Получение имени команды
     * @return имя команды
     */
    public String getName(){ return this.name;}

    /**
     * Установка имени команды
     * @param value новое имя команды
     */
    protected void setName(String value){ this.name = value;}

    /**
     * Получение информации о команде
     * @return информация о команде
     */
    public String getInfo(){ return this.info;}

    /**
     * .установка информации о команде
     * @param value новая информация о команде
     */
    protected void setInfo(String value){ this.info = value;}

    /**
     * Получение информации о системе вывода
     * @return информация о выводе
     */
    protected Consumer<JSONObject> getOutHandler(){ return this.outputHandler;}

    public BasicCommand(String name, String info, Consumer<JSONObject> outputHandler){
        this.setName(name);
        this.setInfo(info);
        this.outputHandler = outputHandler;
    }
    public BasicCommand(String name, String info){
        this.setName(name);
        this.setInfo(info);
        this.outputHandler = null;
    }

    /**
     * Запуск команды
     * @param args необходимые для работы команды аргументы
     * @param engine движок клиента
     * @throws Exception для любых возможных ошибок
     */
    abstract public void execute(HashMap<String, String> args, Engine engine) throws Exception;
}
