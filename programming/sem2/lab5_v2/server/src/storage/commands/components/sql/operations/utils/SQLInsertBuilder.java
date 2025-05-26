package storage.commands.components.sql.operations.utils;

public class SQLInsertBuilder {
    private String data;

    public SQLInsertBuilder(String tableName) {
        this.data = "INSERT INTO " + tableName + " VALUES (";
    }
    public SQLInsertBuilder addQuoted(String data){
        this.data += "'" + data + "',";
        return this;
    }
    public <T> SQLInsertBuilder addRaw(T data){
        this.data +=  data.toString() + ",";
        return this;
    }
    public String build(){
        return this.data.substring(0, this.data.length()-2) + ");";
    }
}
