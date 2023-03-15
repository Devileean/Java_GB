package Devileean;

import Devileean.model.Goods;

import java.util.ArrayList;
import java.util.List;

import static Devileean.functions.Functions.enterNumber;

/**
 * 2. Сведения о товаре состоят из наименования, страны-производителя, веса, цены, сорта.
 * Получить наименования товаров заданного сорта с наименьшей ценой.
 */
public class Task002 {
    public static void main(String[] args) {
        int searchSort = enterNumber("Введите сорт от 1 до 3:");
        Goods good1 = new Goods("Товар1", 10.0, 1, 10, "Россия");
        Goods good2 = new Goods("Высший1", 20.0, 2, 100, "Индия");
        Goods good3 = new Goods("Товар2", 30.0, 3, 1500, "Индия");
        Goods good4 = new Goods("Товар3", 40.0, 1, 20, "Македония");
        Goods good5 = new Goods("Высший2", 20.0, 2, 280, "Россия");
        Goods good6 = new Goods("Товар4", 60.0, 3, 6000, "Россия");

        List<Goods> listGoods = new ArrayList<>();
        listGoods.add(good1);
        listGoods.add(good2);
        listGoods.add(good3);
        listGoods.add(good4);
        listGoods.add(good5);
        listGoods.add(good6);
        if (searchSort <= 3 & searchSort >= 1) {
            System.out.println("Найменования товаров с наименьшей ценой: " + calculateMinPrice(listGoods, searchSort));
        } else {
            System.out.println("Введено не корректное число");
        }
    }

    /**
     * Функция получение по указанной сортировке товаров с найменьшей ценой
     *
     * @param listGoods  List<Goods>  массив товаров
     * @param searchSort int указанная сортировка
     * @return List<String> возвращает массив названий товаров
     */
    private static List<String> calculateMinPrice(List<Goods> listGoods, int searchSort) {
        List<String> result = new ArrayList<>();
        double minPrice = -1;
        for (Goods good : listGoods) {
            if (good.getSort() == searchSort) {
                if (minPrice == -1) {
                    minPrice = good.getPrice();
                }
                if (good.getPrice() < minPrice) {
                    minPrice = good.getPrice();
                    result.clear();
                    result.add(good.getName());
                } else if (good.getPrice() == minPrice) {
                    result.add(good.getName());
                }
            }
        }
        return result;
    }
}