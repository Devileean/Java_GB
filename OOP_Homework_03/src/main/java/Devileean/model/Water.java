package Devileean.model;

public class Water extends Product {
    private final Integer volume;

    public Water(String name, Double price, int volume) {
        super(name, price);
        this.volume = volume;
    }

    public Integer getVolume() {
        return volume;
    }
}
