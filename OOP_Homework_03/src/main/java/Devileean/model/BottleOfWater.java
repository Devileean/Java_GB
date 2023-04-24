package Devileean.model;

/**
 * Бутылка воды наследуется от продукта
 */
public class BottleOfWater extends Product {
    private int volume;

    /**
     * Бутылка воды
     *
     * @param name   string название
     * @param cost   double цена
     * @param volume int объём
     */
    public BottleOfWater(String name, double cost, int volume) {
        super(name, cost);
        this.volume = volume;
    }

    /**
     * геттеры и сеттеры
     */
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
        return "Бутылка воды " + '\'' + super.getName() + '\'' +
                " объём='" + this.volume + '\'' +
                ", цена=" + super.getCost();
    }
}
