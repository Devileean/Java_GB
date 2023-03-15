package Devileean;

import static Devileean.functions.Functions.*;

/**
 * 4(*) при входном массиве, вернуть массив массивов со всеми перестановками его элементов. (со звездочкой)
 * Пример входных данных:
 * [1,2,3]
 * Пример выходных данных:
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Task004 {
    public static void main(String[] args) {
        System.out.println("Входные данные:");
        int[] arr = {1, 2, 3};
        printArray(arr);
        int count = factorial(arr.length);
        int max = arr.length - 1;
        int shift = max;
        System.out.println("Выходные данные:");
        System.out.print("[");
        for (int i = 0; i <= count; i++) {
            int t = arr[shift];
            arr[shift] = arr[shift - 1];
            arr[shift - 1] = t;
            if (i == count) printWithEndText(arr, "");
            else printWithEndText(arr, ",");
            if (shift < 2) {
                shift = max;
            } else {
                shift--;
            }
        }
        System.out.println("]");
        System.out.println("Вариантов: " + count);
    }
}