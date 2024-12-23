package src.Locations.LocationsEnums;

public enum SmellType {
    SMOKE, FOOD;

    @Override
    public String toString() {
        return switch (this) {
            case SMOKE -> "дыма";
            case FOOD -> "еды";
        };
    }
}
