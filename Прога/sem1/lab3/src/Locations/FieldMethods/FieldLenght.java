package src.Locations.FieldMethods;

public class FieldLenght {
    private int fieldLenght;

    public void setFieldLenght(int fieldLenght) {
        this.fieldLenght = fieldLenght;
    }
    public int getFieldLenght() {return this.fieldLenght;}
    public void incrementFieldLenght(){
        this.setFieldLenght(this.getFieldLenght()-1);
    }
}
