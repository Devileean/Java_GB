package Console;

import java.util.*;

import Console.ConsoleInterface.InterMenu;
import Console.ConsoleInterface.InterPrint;
import Console.ConsoleInterface.InterPrintArray;
import Console.ConsoleInterface.InterPrintMapSS;
import Console.ConsoleInterface.InterPrintln;
import Console.ConsoleInterface.InterShow;
import Console.ConsoleInterface.InterValueDou;
import Console.ConsoleInterface.InterValueInt;
import Console.ConsoleInterface.InterValueStr;

public class View implements InterValueDou, InterValueInt, InterValueStr, InterPrintln,
        InterShow, InterPrint, InterPrintArray, InterMenu, InterPrintMapSS {

    // --------------------- Ввод данных в консоль--------------------------//

    /**
     * Ввод данных в формате double
     *
     * @param text - текст для вывода в консоль
     * @return
     */
    @Override
    public Double getValueDou(String text) {
        Scanner scannerDou = new Scanner(System.in);
        System.out.print(text);
        Double dataDou = scannerDou.nextDouble();
        scannerDou.close();
        return dataDou;
    }

    /**
     * Ввод данных в формате Integer
     *
     * @param text - текст для вывода в консоль
     * @return
     */
    @Override
    public Integer getValueInt(String text) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.print(text);
        Integer dataInt = scannerInt.nextInt();
        return dataInt;
    }

    /**
     * Ввод данных в формате String
     *
     * @param text - текст для вывода в консоль
     * @return
     */
    @Override

    public String getValueStr(String text) {
        Scanner scannerStr = new Scanner(System.in, "Cp866");
        System.out.print(text);
        String dataStr = scannerStr.nextLine();
        return dataStr;
    }

    // ----------------------- Вывод данных в консоль ---------------------------///

    /**
     * Вывод данных в консоль в формате data + value
     *
     * @param value - данные в виде double
     * @param data  - данные в виде String - комментарии
     */
    @Override
    public void show(Double value, String data) {
        System.out.printf("%s %f\n", data, value);

    }

    /**
     * Вывод данных в консоль с переносом на следующую строку
     *
     * @param text
     */
    @Override
    public void println(String text) {
        System.out.println(text);
    }

    /**
     * Вывод данных в консоль без переноса на следующую строку
     *
     * @param text
     */
    @Override
    public void print(String text) {
        System.out.print(text);
    }

    /**
     * Вывод данных массива в консоль
     */
    @Override
    public void printArray(Integer[] array) {
        System.out.print("[ ");
        for (int index = 0; index < array.length; index++) {
            if (index != array.length - 1)
                System.out.print(array[index].toString() + ",");
            else
                System.out.print(array[index].toString() + " ]\n");

        }
    }

    /*
     * Метод вывода в консоль структуры Map
     */

    @Override
    public void printMap(Map<String, String> listMap) {
        System.out.print("{ ");
        System.out.print("ID:" + listMap.get("ID") + ", ");
        System.out.print("Наименование:" + listMap.get("Name") + ", ");
        System.out.print("Количество игрушек:" + listMap.get("Quantity") + ", ");
        System.out.print("Вероятность выпадения:" + listMap.get("Possibility") + " }\n");
    }

    public void printQueue(Queue<String> listRaffledToys){
        System.out.print("[");
        for (String dataItr : listRaffledToys) {

            System.out.print(dataItr+",");

        }
        System.out.println("]");
    }

    // ---------------------- Работа с интерфейсом консоли в программе -------//
    /**
     * Вывод в консоль операций калькулятора для Рациональных чисел
     *
     * @return - выбор типа действий
     */
    @Override
    public Integer Menu() {
        StringBuilder sb = new StringBuilder()
                .append("\n ==== \n")
                .append("Розыгрыш игрушек в магазине детских товаров.\n")
                .append("0 - Вывод в консоль списка игрушек для розыгрыша.\n")
                .append("1 - Вывод в консоль списка разыгранных игрушек\n")
                .append("2 - Добавить наименование новых игрушек для розыгрыша.\n")
                .append("3 - Изменение данных в существующих игрушкам для розыгрыша.\n")
                .append("4 - Удаление наименования игрушек для розыгрыша.\n")
                .append("5 - Разыграть игрушки.\n")
                .append("6 - Получение игрушек.\n")
                .append("7 - Выход.\n");

        println(sb.toString());

        Integer temp = getValueInt("Введите число от 0 до 7: ");
        return temp;

    }

    public Integer MenuChange() {
        StringBuilder sb = new StringBuilder()
                .append("\n")
                .append("Выберите что будете редактировать:\n")
                .append("1 - Наименование игрушки.\n")
                .append("2 - Количество игрушек.\n")
                .append("3 - Частоту выпадения игрушки.\n")
                .append("0 - Выход из редактирования.\n");

        println(sb.toString());

        Integer temp = getValueInt("Введите число от 0 до 3: ");
        return temp;

    }

}
