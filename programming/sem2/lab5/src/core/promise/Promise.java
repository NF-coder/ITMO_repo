package core.promise;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.function.UnaryOperator;

public class Promise{
    private final String opName;
    private Enum<PromiseStatus> status = PromiseStatus.CREATED;
    private final HashMap<String,String> args;
    private HashMap<String,String> result = new HashMap<>();
    private String errorDescription;

    public Promise(String opName, HashMap<String,String> args){
        this.opName = opName;
        this.args = args;
    }

    public String getOperationName(){
        return this.opName;
    }

    public HashMap<String,String> getArguments(){
        this.status = PromiseStatus.EXECUTING;
        return this.args;
    }

    public HashMap<String, String> getResult(){
        return this.result;
    }
    public void setResult(HashMap<String,String> result){
        this.result = result;
        this.status = PromiseStatus.FINISHED;
    }

    public String getError(){
        return this.errorDescription;
    }
    public void setError(String descr){
        this.errorDescription = descr;
        this.status = PromiseStatus.ERROR;
    }

    public Enum<PromiseStatus> getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return "Promise{" +
                "\n\t opName=" + this.getOperationName() +
                "\n\t status=" + this.status;
    }
}