package Devileean;


import java.util.Deque;
import java.util.LinkedList;

/**
 * Вывести список на экран в перевернутом виде (без массивов и ArrayList)
 * Пример:
 * 1 -> 2->3->4
 * Вывод:
 * 4->3->2->1
 */
public class Task_01 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < 5; i++) {
            list.add(i);
        }
        System.out.println("Созданный лист: " + list);

        exersize(list);
    }

    /**
     * Реверс листа
     *
     * @param list на вход созданный лист 1 2 3 4
     *             результат печати листа в обратном порядке
     */
    private static void exersize(LinkedList<Integer> list) {
        Deque<Integer> revers = new LinkedList<>();
        for (Integer integer : list) {
            revers.addFirst(integer);
        }
        System.out.println("Реверс: " + revers);
    }
}
