package Devileean.model;

import Devileean.interfacess.VendingMachine;

import java.util.List;

/**
 * Вендинговый автомат бутылочный реализуется от интерфейса вендингового автомата
 */
public class BottleOfWaterVendingMachine implements VendingMachine {
    private final List<Product> products;

    /**
     * Вендинговый автомат бутылочный
     *
     * @param products список продуктов
     */
    public BottleOfWaterVendingMachine(List<Product> products) {
        this.products = products;
    }

    /**
     * Получить продукт
     *
     * @param name string Название
     * @return list продукт
     */
    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
    }

    /**
     * Получить продукт бутылочный
     *
     * @param name   string Название
     * @param volume int Объём
     * @return list продукт
     */
    public BottleOfWater getProduct(String name, int volume) {
        for (Product product : products) {
            if (product instanceof BottleOfWater) {
                if (product.getName().equalsIgnoreCase(name) && ((BottleOfWater) product).getVolume() == volume) {
                    return (BottleOfWater) product;
                }
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
    }
}
