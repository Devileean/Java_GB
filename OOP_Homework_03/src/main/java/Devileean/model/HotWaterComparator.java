package Devileean.model;

import java.util.Comparator;

public class HotWaterComparator implements Comparator<Product> {

    private final String type;

    public HotWaterComparator(String type) {
        this.type = type;
    }

    @Override
    public int compare(Product o1, Product o2) {
        HotWater p1 = (HotWater) o1;
        HotWater p2 = (HotWater) o2;
        if(this.type.equals("temperature")){
            return p1.getTemperature() - p2.getTemperature();
        }
        if(this.type.equals("volume")){
            return p1.getVolume() - p2.getVolume();
        }
        return 0;
    }
}
