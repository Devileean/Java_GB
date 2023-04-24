package Devileean.model;

public class HotWater extends Water {
    private final Integer temperature;

    public HotWater(String name, double cost, int volume, int temperature) {
        super(name, cost, volume);
        this.temperature = temperature;
    }


    public Integer getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return String.format("name: %s vol: %d temp %d",getName(),getVolume(), getTemperature());
    }
}
