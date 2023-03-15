package Devileean.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * названия, фамилии автора, цены, года издания и количества страниц
 */
@Data
@AllArgsConstructor
public class Book {
    private String name;
    private String author;
    private int price;
    private int year;
    private int pageCount;
}