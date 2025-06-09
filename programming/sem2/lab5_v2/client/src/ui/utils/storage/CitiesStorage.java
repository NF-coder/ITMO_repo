package ui.utils.storage;

import org.json.JSONArray;

public class CitiesStorage {
    public JSONArray arr;

    public synchronized void setArr(JSONArray arr) {
        this.arr = arr;
    }
    public synchronized JSONArray getArr(){
        return this.arr;
    }
}
