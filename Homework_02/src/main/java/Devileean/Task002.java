package Devileean;

import java.util.Scanner;

public class Task002 {
    public static void main(String[] args) {
        System.out.println("Дана последовательность из N целых чисел. Верно ли, что последовательность является возрастающей.");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("grows: " + isGrowingSecuence(n));
    }

    /**
     * @param n длина последовательности
     * @return является ли последовательность возрастающей
     */
    private static boolean isGrowingSecuence(int n) {
        boolean result = true;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b;
        for (int i = 1; i < n; i++) {
            b = sc.nextInt();
            if (b <= a) {
                result = false;
            }
            a = b;
        }
        return result;

    }
}
