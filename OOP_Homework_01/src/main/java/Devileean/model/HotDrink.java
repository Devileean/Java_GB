package Devileean.model;

/**
 * Горячий напиток наследует поля от продукта
 */
public class HotDrink extends Product {
    private int temperature;
    private int sugar;
    private int volume;

    /**
     * Горячий напиток
     *
     * @param name        string Название
     * @param cost        double Цена
     * @param temperature int Температура
     * @param sugar       int Сахар
     * @param volume      int Объём
     */
    public HotDrink(String name, double cost, int temperature, int sugar, int volume) {
        super(name, cost);
        this.temperature = temperature;
        this.sugar = sugar;
        this.volume = volume;
    }

    /**
     * Геттеры и сеттеры для полей напитка
     */
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Вывод в строку данной модели
     *
     * @return string сформированная строка
     */
    @Override
    public String toString() {
        return "Горячий напиток " + '\'' + this.getName() + '\'' +
                " Температура=" + temperature +
                " Сахар=" + sugar +
                " Объём=" + volume +
                " Цена=" + this.getCost();
    }
}