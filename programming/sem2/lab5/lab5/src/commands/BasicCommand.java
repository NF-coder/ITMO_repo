package commands;

public abstract class BasicCommand {
    private String name;
    private String info;

    public String getName(){
        return this.name;
    }
    public String getInfo(){
        return this.info;
    }

    void execute(){};
}
