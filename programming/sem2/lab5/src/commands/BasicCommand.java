package commands;

import java.util.HashMap;

public abstract class BasicCommand {
    private String name;
    private String info;

    public String getName(){ return this.name;}
    protected void setName(String value){ this.name = value;}
    public String getInfo(){ return this.info;}
    protected void setInfo(String value){ this.info = value;}

    public BasicCommand(String name, String info){
        this.setName(name);
        this.setInfo(info);
    }

    abstract public void execute(HashMap<String, String> args);
}
