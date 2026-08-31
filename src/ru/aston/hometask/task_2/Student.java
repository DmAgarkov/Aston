package hometask.task_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Student {
    private final String name;
    private final List<Book> books;
    private static final Map<String, Student> allStudents = new ConcurrentHashMap<>();

    private Student(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        allStudents.put(name, this);
    }

    public static Student createStudent(String name) {
        if (allStudents.containsKey(name)) return allStudents.get(name);
        return new Student(name);
    }

    public static List<Student> getAllStudents() {
        return new ArrayList<>(allStudents.values());
    }

    public Student addBook(Book newBook) {
        if (newBook != null) {
            books.add(newBook);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public static List<Student> createStudents(String filePath) {
        try (var lines = Files.lines(Path.of(filePath))) {
            lines.filter(line -> !line.trim().isEmpty())
                    .forEach(line -> {
                        String[] data = line.split(", ");
                        if (data.length >= 4) {
                            createStudent(data[0].trim())
                                    .addBook(Book.createBook(
                                            data[1].trim(),
                                            Integer.parseInt(data[2].trim()),
                                            Integer.parseInt(data[3].trim())
                                    ));
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + filePath, e);
        }
        return new ArrayList<>(allStudents.values());
    }

    @Override
    public String toString() {
        return name;
    }
}