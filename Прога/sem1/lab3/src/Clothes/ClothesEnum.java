package src.Clothes;
import src.Clothes.Cloth;

public enum ClothesEnum {
    JACKET, TROUSERS;

    public Cloth toCloth(int stepIncrement) {
        return switch (this) {
            case JACKET -> new Cloth("пиджака", stepIncrement);
            case TROUSERS -> new Cloth("штанов", stepIncrement);
        };
    }
}
