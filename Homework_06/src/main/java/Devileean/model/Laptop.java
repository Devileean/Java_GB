package Devileean.model;

import java.util.Objects;
import java.util.Random;

public class Laptop {
    /*
     * 1 - ОЗУ
     * 2 - Объем ЖД
     * 3 - Операционная система
     * 4 - Цвет
     * */

    private final int ram; // 8, 16, 32, 64
    private final int hddSize; // 512, 1024, 2048
    private final String os; // Windows 10, Windows 11, MacOS, Linux
    final String color; // black, silver, blue, white, red
    final String manufacturer; // Lenovo, Apple, Asus, HP, Acer

    public final static int[] ramSizes = {8, 16, 32, 64};
    public final static int[] hddSizes = {512, 1024, 2048};
    public final static String[] osNames = {"Windows 10", "Windows 11", "MacOs", "Linux"};
    public final static String[] colors = {"black", "silver", "blue", "white", "red"};
    public final static String[] manufacturers = {"Lenovo", "Apple", "Asus", "HP", "Acer"};

    /**
     * Задать значения в переменные
     *
     * @param ram          число оперативки
     * @param hddSize      число объём жесткого диска
     * @param os           строка ось
     * @param color        строка цвет
     * @param manufacturer строка производитель
     */
    public Laptop(int ram, int hddSize, String os, String color, String manufacturer) {
        this.manufacturer = manufacturer;
        if (manufacturer.equalsIgnoreCase("apple")) this.os = "MacOS";
        else this.os = os;
        this.ram = ram;
        this.hddSize = hddSize;
        this.color = color;
    }

    /**
     * Функция генерации ноутбука
     */
    public Laptop() {
        this.manufacturer = generateManufacturer();
        if (manufacturer.equalsIgnoreCase("apple")) this.os = "MacOS";
        else this.os = generateOS();
        this.ram = generateRAMSize();
        this.hddSize = generateHDDSize();
        this.color = generateColor();
    }

    /**
     * Получить оперативку
     *
     * @return число
     */
    public int getRam() {
        return ram;
    }

    /**
     * Получить ХДД
     *
     * @return число
     */
    public int getHddSize() {
        return hddSize;
    }

    /**
     * Получить ось
     *
     * @return строка
     */
    public String getOs() {
        return os;
    }

    /**
     * Соответствие
     *
     * @param o объект
     * @return правда или лож
     */
    public boolean corresponds(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;

        return (laptop.getRam() <= 0 || getRam() == laptop.getRam()) && (laptop.getHddSize() <= 0 || getHddSize() == laptop.getHddSize()) && (laptop.getOs().length() == 0 || getOs().equalsIgnoreCase(laptop.getOs())) && (laptop.color.length() == 0 || color.equalsIgnoreCase(laptop.color)) && (laptop.manufacturer.length() == 0 || manufacturer.equalsIgnoreCase(laptop.manufacturer));

    }

    /**
     * Вернуть строку
     *
     * @return строка
     */
    @Override
    public String toString() {
        return "Laptop {" + manufacturer + ", ram: " + ram + ", hddSize: " + hddSize + ", os: '" + os + '\'' + ", color: '" + color + '\'' + '}';
    }

    /**
     * Равно
     *
     * @param o объект
     * @return правда или лож
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return getRam() == laptop.getRam() && getHddSize() == laptop.getHddSize() && getOs().equals(laptop.getOs()) && Objects.equals(color, laptop.color) && manufacturer.equals(laptop.manufacturer);
    }

    /**
     * Хешкод
     *
     * @return число
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRam(), getHddSize(), getOs(), color, manufacturer);
    }

    /**
     * Генерация оперативки
     *
     * @return число
     */
    private static int generateRAMSize() {
        Random rnd = new Random();
        return Laptop.ramSizes[rnd.nextInt(Laptop.ramSizes.length)];
    }

    /**
     * Генерация хдд
     *
     * @return число
     */
    private static int generateHDDSize() {
        Random rnd = new Random();
        return Laptop.hddSizes[rnd.nextInt(Laptop.hddSizes.length)];
    }

    /**
     * Генерация оси
     *
     * @return строка
     */
    private static String generateOS() {
        Random rnd = new Random();
        return Laptop.osNames[rnd.nextInt(Laptop.osNames.length)];
    }

    /**
     * Генерация цвета
     *
     * @return строка
     */
    private static String generateColor() {
        Random rnd = new Random();
        return Laptop.colors[rnd.nextInt(Laptop.colors.length)];
    }

    /**
     * Генерация производителя
     *
     * @return строка
     */
    private static String generateManufacturer() {
        Random rnd = new Random();
        return Laptop.manufacturers[rnd.nextInt(Laptop.manufacturers.length)];
    }
}
