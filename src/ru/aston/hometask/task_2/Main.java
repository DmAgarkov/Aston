package hometask.task_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Student> students = Student.createStudents("src/main/java/org/Task_2/students.txt");
        List<Book> books = students.stream()
                .flatMap(student -> student.getBooks().stream())
                .toList();

        System.out.println("\n[1] ВСЕ СТУДЕНТЫ:");
        students.forEach(System.out::println);

        System.out.println("\n[2] СТУДЕНТЫ И ИХ КНИГИ:");
        students.stream()
                .map(s -> String.format("%s: %s", s.getName(), s.getBooks()))
                .forEach(System.out::println);

        System.out.println("\n[4] КНИГИ ПО СТРАНИЦАМ:");
        books.stream()
                .sorted(Comparator.comparingInt(Book::getPages))
                .forEach(book -> System.out.println(book + " (" + book.getPages() + " стр.)"));

        System.out.println("\n[5] УНИКАЛЬНЫЕ КНИГИ:");
        books.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n[6] КНИГИ ПОСЛЕ 2000 ГОДА:");
        books.stream()
                .filter(book -> book.getYear() > 2000)
                .forEach(System.out::println);

        System.out.println("\n[7] ТОП-3 КНИГИ:");
        books.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n[8] ГОДЫ ВЫПУСКА ВСЕХ КНИГ:");
        books.stream()
                .map(Book::getYear)
                .forEach(System.out::println);

        System.out.println("\n[9-10] ПОИСК КНИГИ ПО ГОДУ (короткое замыкание):");
        int searchYear = 1813;

        books.stream()
                .filter(book -> book.getYear() == searchYear)
                .findFirst()
                .ifPresentOrElse(
                        book -> System.out.printf("Найдена книга: %s (год: %d)", book.getName(), book.getYear()),
                        () -> System.out.println("Книг за " + searchYear + " год не найдено")
                );

    }
}
