package ui.utils;

import textWorkers.Invokers.UIInvoker;

public class ReqController {
    String login;
    String password;
    UIInvoker invoker;

    public ReqController(UIInvoker invoker){
        this.invoker = invoker;
    }
    public void setUserInfo(String login, String password){
        this.login = login;
        this.password = password;
    }
    public ReqBuilder call(String opName){
        return new ReqBuilder(login, password, opName, invoker);
    }
}
