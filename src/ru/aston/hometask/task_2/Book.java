package hometask.task_2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Book {
    private final String name;
    private final int year;
    private final int pages;

    private static final Map<String, Book> allBooks = new ConcurrentHashMap<>();

    private Book(String name, int year, int pages) {
        this.name = name;
        this.year = year;
        this.pages = pages;
        allBooks.put(generateKey(name, year), this);
    }

    private static String generateKey(String name, int year) {
        return name + "|" + year;
    }

    public static Book createBook(String name, int year, int pages) {
        String key = name + "|" + year;
        if (allBooks.containsKey(key)) return allBooks.get(key);
        return new Book(name, year, pages);
    }

    public static List<Book> getAllBooks() {
        return new ArrayList<>(allBooks.values());
    }

    public String getName() { return name; }
    public int getYear() { return year; }
    public int getPages() { return pages; }

    @Override
    public String toString() {
        return String.format("%s: %d г. %d с.", name, year, pages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }
}