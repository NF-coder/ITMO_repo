package storage.commands.components.sql.operations.utils;

public class SQLInsertBuilder {
    private String data;

    public SQLInsertBuilder(String tableName) {
        this.data = "INSERT INTO " + tableName + " VALUES (";
    }
    public SQLInsertBuilder(String tableName, String[] columns) {
        StringBuilder column_names = new StringBuilder();
        for (String column : columns) {
            column_names.append(column).append(",");
        }
        this.data = "INSERT INTO " + tableName + " (" + column_names.substring(0, column_names.length()-1) + ") " + "VALUES (";
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
        return this.data.substring(0, this.data.length()-1) + ");";
    }
}
