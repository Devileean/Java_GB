public class Main {

    public static void main(String[] args) {
        // Создаем список: 1 -> 10 -> 125 -> 13 -> -5 -> 120 -> null
        LinkedList<Integer> newList;
        newList = new LinkedList<>();
        newList.add(1);
        newList.add(10);
        newList.add(125);
        newList.add(13);
        newList.add(-5);
        newList.add(120);
        // Выводим исходный список
        newList.print();
        // Разворачиваем список
        newList.reverseList();
        // Выводим развернутый список
        newList.print();
    }
}