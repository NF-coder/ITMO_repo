package ui.utils;

import org.json.JSONObject;
import textWorkers.Invokers.UIInvoker;
import ui.utils.storage.ResultStorage;

import java.util.HashMap;

public class ReqBuilder {
    HashMap<String,String> data = new HashMap<>();
    String opName;
    UIInvoker invoker;

    public ReqBuilder(String login, String passwd, String opName, UIInvoker invoker){
        data.put("password", passwd);
        data.put("login", login);
        this.opName = opName;
        this.invoker = invoker;
    }

    public ReqBuilder addArg(String name, String value){
        data.put(name, value);
        return this;
    }

    public JSONObject build(){
        invoker.setInfo(opName, data);
        return ResultStorage.getResult();
    }
}
