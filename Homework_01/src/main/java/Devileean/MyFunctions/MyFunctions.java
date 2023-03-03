package Devileean.MyFunctions;

import java.util.Scanner;

public class MyFunctions {
    /**
     * Функция вывода заготовленного текста и возврата введённого в консоль
     * @param text строка или много слов
     * @return Строку
     */
    public static String enter_text(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    /**
     * Функция вывода заготовленного текста и возврата введённого числа в консоль
     * @param text строка или много слов
     * @return Число
     */
    public static int enter_number(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
