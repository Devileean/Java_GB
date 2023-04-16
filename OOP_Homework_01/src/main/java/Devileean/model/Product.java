package Devileean.model;

/**
 * Продукт
 */
public abstract class Product {
    private String name;
    private double cost;

    /**
     * Продукт
     *
     * @param name string название
     * @param cost double цена
     */
    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * Геттеры и сеттеры полей модели Продукта
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Вывод в строку данной модели
     *
     * @return string сформированная строка
     */
    @Override
    public String toString() {
        return "Продукт " +
                "Название='" + name + '\'' +
                ", цена=" + cost;
    }
}