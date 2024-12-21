package src;

public interface IBasicObj {
    public String getName();
    public int getId();

    @Override
    public String toString();

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();
}
