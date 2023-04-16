package Devileean;

import Devileean.model.*;

import java.util.ArrayList;
import java.util.List;

// Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.
// Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и реализовать перегруженный метод getProduct(int name, int volume, int temperature) выдающий продукт соответствующий имени, объему и температуре
// В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести логику заложенную в программе
// Все вышеуказанное создать согласно принципам ООП пройдённым на семинаре
public class Main {
    public static void main(String[] args) {
        // Создали новый массив(с предустановленными полями продукта это имя и цена) и положили в переменную lstBW
        List<Product> lstBW = new ArrayList<>();
        // Закинули в список продукты с расширением(Volume) от бутылки воды, тем самым добавив 3 параметр к продукту
        lstBW.add(new BottleOfWater("water 0.5l", 200.0, 200));
        lstBW.add(new BottleOfWater("water 1l", 300.0, 300));
        // Создали вендинг машину и закинули туда созданные продукты положив в переменную машина
        BottleOfWaterVendingMachine machine = new BottleOfWaterVendingMachine(lstBW);
        // передаем список продукций от вендинговой машины и запускаем функцию получить продукт и кладём в бутылку воды
        BottleOfWater water = machine.getProduct("water 1l", 300);
        // Бутылка воды наследуется от продукта и содержит все поля что и продукт с дополнительным волюм полем
        System.out.println(water);


        List<Product> lstHD = new ArrayList<>();
        lstHD.add(new HotDrink("espresso", 200.0, 90, 2, 300));
        lstHD.add(new HotDrink("capuchino", 300.0, 90, 3, 500));
        lstHD.add(new HotDrink("latte", 300.0, 90, 3, 500));
        lstHD.add(new HotDrink("maciatto", 300.0, 90, 3, 500));
        HotDrinksVendingMachine vending = new HotDrinksVendingMachine(lstHD);
        HotDrink drink = vending.getProduct("espresso", 300, 90);
        System.out.println(drink);
    }
}