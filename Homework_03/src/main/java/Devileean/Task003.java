package Devileean;

import Devileean.model.Book;

import java.util.ArrayList;
import java.util.List;

import static Devileean.functions.Functions.isSimpleNumber;

/**
 * 3. Сведения о книге состоят из названия, фамилии автора, цены, года издания и количества страниц.
 * Найти названия книг, в которых простое количество страниц, фамилия автора содержит «А»
 * и год издания после 2010 г, включительно.
 */
public class Task003 {
    public static void main(String[] args) {
        Book book1 = new Book("Война и мир", "Толстой Лев Николаевич", 100, 1900, 1500);
        Book book2 = new Book("Вий", "Николай Васильевич Гоголь", 100, 1950, 17);
        Book book3 = new Book("История будущего", "Аркадий и Борис Стругацкие", 100, 2010, 17);
        Book book4 = new Book("Волшебник Изумрудного города", "Александр Мелентьевич Волков", 100, 2010, 37);
        Book book5 = new Book("Таинственный остров", "Жюль Верн", 100, 2015, 47);
        Book book6 = new Book("Преступление и наказание. Идиот", "Достоевский Федор Михайлович", 922, 2022, 46);

        List<Book> listBooks = new ArrayList<>();
        listBooks.add(book1);
        listBooks.add(book2);
        listBooks.add(book3);
        listBooks.add(book4);
        listBooks.add(book5);
        listBooks.add(book6);
        System.out.println(findBooks(listBooks));
    }

    /**
     * Функция поиска книг по условию задачи
     *
     * @param listBooks массив книг
     * @return массив названий книг по условию
     */
    private static List<String> findBooks(List<Book> listBooks) {
        List<String> result = new ArrayList<>();
        for (Book book : listBooks) {
            boolean contA = (book.getAuthor().contains("А") | book.getAuthor().contains("а"));
            int pageCont = book.getPageCount();
            int year = book.getYear();
            String name = book.getName();
            if (isSimpleNumber(pageCont) & contA & year >= 2010) {
                result.add(name);
            }
        }
        return result;
    }
}