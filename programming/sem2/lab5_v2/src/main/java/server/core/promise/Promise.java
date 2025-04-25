package server.core.promise;

import netscape.javascript.JSObject;

import java.util.HashMap;

public class Promise implements Runnable{
    private final String opName;
    private final JSObject args;

    private Enum<PromiseStatus> status;
    private HashMap<String,String> result = new HashMap<>();

    public Promise(String opName, JSObject args, Commands){
        this.opName = opName;
        this.args = args;
        this.status =  PromiseStatus.CREATED;
    }

    public void run(){
        this.status =  PromiseStatus.EXECUTING;
        this.opName =
    }

    public void setResult(HashMap<String,String> result){
        this.result = result;
        this.status = PromiseStatus.FINISHED;
    }
    public void setError(String error){
        this.result.put("error", error);
        this.status = PromiseStatus.ERROR;
    }
    public HashMap<String, String> getResult(){
        return this.result;
    }
    public Enum<PromiseStatus> getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return "Promise{" +
                "\n\t opName=" + this.opName +
                "\n\t status=" + this.status +
                "\n}";
    }
}