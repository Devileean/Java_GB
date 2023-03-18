package Devileean;


import java.util.Deque;
import java.util.LinkedList;

/**
 * Учитывая строку s, содержащую только символы '(', ')', '{', '}', '[' и ']', определите,
 * допустима ли входная строка. Входная строка действительна, если: Открытые скобки должны быть
 * закрыты однотипными скобками. Открытые скобки должны быть закрыты в правильном порядке.
 * Каждой закрывающей скобке соответствует открытая скобка того же типа.
 */
public class Task_02 {
    public static void main(String[] args) {
        String text1 = "())";
        String text2 = "()[]{}";
        String text3 = "(]";
        String text4 = "([)]";
        String text5 = "";
        String text6 = "([])";

        System.out.println("1 = " + parentCheck(text1));
        System.out.println("2 = " + parentCheck(text2));
        System.out.println("3 = " + parentCheck(text3));
        System.out.println("4 = " + parentCheck(text4));
        System.out.println("5 = " + parentCheck(text5));
        System.out.println("6 = " + parentCheck(text6));
    }

    /**
     * Провека скобок,пар
     *
     * @param text входит строка символов
     * @return True \ False
     */
    private static boolean parentCheck(String text) {
        Deque<Character> list = new LinkedList<>();
        for (Character symbol : text.toCharArray()) {
            if (symbol == '(') list.add(')');
            else if (symbol == '[') list.add(']');
            else if (symbol == '{') list.add('}');
            else if (list.isEmpty() || list.pop() != symbol) return false;
        }
        return true;
    }
}
