package Devileean.model;

import Devileean.interfacess.VendingMachine;

import java.util.List;

/**
 * Вендинговый автомат горячих напитков реализуется от интерфейса вендингового автомата
 */
public class HotDrinksVendingMachine implements VendingMachine {
    private final List<Product> products;

    /**
     * Вендинговый автомат горячих напитков
     *
     * @param products список продуктов
     */
    public HotDrinksVendingMachine(List<Product> products) {
        this.products = products;
    }

    /**
     * Получить продукт
     *
     * @param name string Название
     * @return list продукт
     */
    @Override
    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
    }

    /**
     * Получить продукт горячий напиток
     *
     * @param name        string Название
     * @param volume      int Объём
     * @param temperature int Температура
     * @return list продукт
     */
    public HotDrink getProduct(String name, int volume, int temperature) {
        for (Product product : products) {
            if (product instanceof HotDrink) {
                if (product.getName().equalsIgnoreCase(name) && ((HotDrink) product).getVolume() == volume
                        && ((HotDrink) product).getTemperature() == temperature) {
                    return (HotDrink) product;
                }
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s, объемом %s и температурой %s" +
                " не найден.", name, volume, temperature));
    }
}
