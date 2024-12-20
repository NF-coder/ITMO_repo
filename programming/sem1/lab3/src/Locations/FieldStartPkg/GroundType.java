package src.Locations.FieldStartPkg;

public enum GroundType {
    SOIL, SAND;

    @Override
    public String toString() {
        return switch (this) {
            case SOIL -> "земли";
            case SAND -> "песка";
        };
    }
}
