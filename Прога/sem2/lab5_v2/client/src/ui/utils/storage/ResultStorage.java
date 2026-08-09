package ui.utils.storage;

import org.json.JSONObject;

public class ResultStorage {
    private static JSONObject result;
    private static boolean isReady;

    public static void setResult(JSONObject result){
        ResultStorage.result = result;
        ResultStorage.isReady = true;
    }
    public static JSONObject getResult(){
        while (!ResultStorage.isReady){
            Thread.yield();
        }
        ResultStorage.isReady = false;
        return result;
    }
}
