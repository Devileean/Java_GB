package Devileean;

public class Task003 {
    public static void main(String[] args) {
        System.out.println("Дан массив целых чисел. Заменить отрицательные элементы на сумму индексов двузначных элементов массива.");
        int[] array = new int[]{-4, 8, 1, 3, 5, 6, -7, 2, -9, 11};
        printArray(array);
        replaceNegative(array);
        printArray(array);
    }

    private static void replaceNegative(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if ((10 <= array[i] && array[i] <= 99) || (-99 <= array[i] && array[i] <= -10)) {
                sum += i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = sum;
            }
        }

    }

    public static void printArray(int[] array) {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            res.append(array[i]).append(i == array.length - 1 ? "]" : ",");
        }
        System.out.println(res);
    }
}
