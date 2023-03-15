package Devileean.functions;

import java.util.Arrays;
import java.util.Scanner;

public class Functions {
    /**
     * Печать массива в консоль
     *
     * @param array массив числовой
     */
    public static void printArray(int[] array) {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            res.append(array[i]).append(i == array.length - 1 ? "]" : ",");
        }
        System.out.println(res);
    }

    /**
     * Вывод числового массива с добавкой текста в конце
     *
     * @param arr  числовой массив
     * @param text конечный текст
     */
    public static void printWithEndText(int[] arr, String text) {
        System.out.printf(Arrays.toString(arr) + text);
    }

    /**
     * Рекурсивная функция факториала
     *
     * @param n число
     * @return число
     */
    public static int factorial(int n) {
        return (n > 0) ? n * factorial(n - 1) : 1;
    }

    /**
     * Функция вывода заготовленного текста и возврата введённого числа в консоль
     *
     * @param text строка или много слов
     * @return Число
     */
    public static int enterNumber(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * Функция проверки на просто число
     *
     * @param a проверяемое число
     * @return true или false
     */
    public static boolean isSimpleNumber(int a) {
        double sq = Math.sqrt(a);
        for (int i = 2; i <= (int) sq; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }
}