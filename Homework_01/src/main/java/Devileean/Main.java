package Devileean;

import Devileean.MyFunctions.MyFunctions;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        example_1();
        example_2();
        example_3();
    }
    /**
     * Решение 1 задачи
     */
    public static void example_1() {
        String strTrim = MyFunctions.enter_text("Введите через пробел слова: ").trim();
        String[] arrWords = strTrim.split(" ");
//        String[] arrWords = MyFunctions.enter_text("Введите через пробел слова: ").trim().split(" ");
        for (int i = 0; i < arrWords.length / 2; i++) {
            String temp = arrWords[i];
            arrWords[i] = arrWords[arrWords.length - 1 - i];
            arrWords[arrWords.length - 1 - i] = temp;
        }
        System.out.println(String.join(" ", arrWords));
    }

    public static void example_2() {
        boolean isFinish = true;
        int a = 0, b = 0, s = 0;
        while (isFinish) {
            int num = MyFunctions.enter_number("Введи число и нажми enter: ");
            if (num == 0) {
                isFinish = false;
            } else {
                if (b == 0 && a != 0) {
                    b = num;
                }
                if (a == 0) {
                    a = num;
                }
                if (a != 0 && b != 0) {
                    if (a > b) {
                        s += a;
                    } else if (a < b) {
                        s += b;
                    } else if (a == b) {
                        s += a;
                    }
                    b = a = 0;
                }
            }
        }
        System.out.println(s);
    }

    public static void example_3() {
        String a = MyFunctions.enter_text("Введите число(пример 11)");
        String b = MyFunctions.enter_text("Введите число(пример 1)");
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);
        BigInteger sum = num1.add(num2);
        System.out.println("Вывод ");
        System.out.println(sum.toString(2));
    }
}

