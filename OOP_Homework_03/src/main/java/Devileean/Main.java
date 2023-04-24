package Devileean;

import Devileean.model.*;

import java.util.ArrayList;
import java.util.List;

//Проделать код ревью своих работ. Продумать, какие компоненты можно и нужно переписать.
public class Main {
    public static void main(String[] args) {
        // Было
        List<Devileean.model.Product> lstBW = new ArrayList<>();
        lstBW.add(new Devileean.model.BottleOfWater("water 0.5l", 200.0, 200));
        lstBW.add(new Devileean.model.BottleOfWater("water 1l", 300.0, 300));
        Devileean.model.BottleOfWaterVendingMachine machine = new Devileean.model.BottleOfWaterVendingMachine(lstBW);
        Devileean.model.BottleOfWater water = machine.getProduct("water 1l", 300);
        System.out.println(water);

        //Стало
        HotDrinksVendingMachine machineHotDrink = new HotDrinksVendingMachine();
        machineHotDrink.addProduct(new HotDrink("espresso", 200.0, 120, 2, 300));
        machineHotDrink.addProduct(new HotDrink("capuchino", 300.0, 90, 3, 500));
        machineHotDrink.addProduct(new HotDrink("latte", 300.0, 100, 3, 500));
        machineHotDrink.addProduct(new HotDrink("maciatto", 300.0, 105, 3, 500));

        machineHotDrink.sort(new HotWaterComparator("temperature"));
        machineHotDrink.printProducts();
        System.out.println("---");
        for (Object item : machineHotDrink){
            System.out.println("iterated: " + item);
        }
    }
}