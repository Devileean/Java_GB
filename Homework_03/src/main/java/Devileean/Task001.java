package Devileean;

import Devileean.model.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Дан массив записей: наименование товара, цена, сорт.
 * Найти наибольшую цену товаров 1го или 2го сорта среди товаров,
 * название которых содержит «Высший».
 */
public class Task001 {
    public static void main(String[] args) {
        Goods good1 = new Goods("prostituts", 10, 1, 10, "Тайланд");
        Goods good2 = new Goods("высший", 20, 2, 100, "Россия");
        Goods good3 = new Goods("religions", 30, 3, 1000, "Иран");
        Goods good4 = new Goods("guns", 40, 1, 20, "Сирия");
        Goods good5 = new Goods("высший", 50, 2, 200, "Россия");
        Goods good6 = new Goods("drugs", 60, 3, 2000, "Пакистан");

        List<Goods> listGoods = new ArrayList<>();
        listGoods.add(good1);
        listGoods.add(good2);
        listGoods.add(good3);
        listGoods.add(good4);
        listGoods.add(good5);
        listGoods.add(good6);

        double maxPrice = 0;
        for (Goods good : listGoods) {
            if (good.getName().contains("высший")
                    & (good.getSort() == 1 | good.getSort() == 2)
                    & good.getPrice() > maxPrice) {
                maxPrice = good.getPrice();
            }
        }
        System.out.println("максимальная цена: " + maxPrice);
    }
}
