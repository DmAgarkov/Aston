package org.Task_1;

public class TestImmutability {
    public static void main(String[] args) {
        // 1. Создаем оригинального Chief и Department
        Chief original = new Chief("Alice", 75000f);
        Department dept = new Department("IT", original);

        System.out.println("=== ТЕСТ 1: Защитное копирование в конструкторе ===");
        System.out.println("Оригинал и копия в Department - разные объекты? " +
                (original != dept.getChief()));

        // 2. Меняем оригинал
        original.setName("Bob");
        original.setSalary(80000f);

        System.out.println("\n=== ТЕСТ 2: Изменение оригинала не влияет на Department ===");
        System.out.println("Chief в Department: " + dept.getChief().getName() +
                ", " + dept.getChief().getSalary());

        // 3. Меняем объект из геттера
        Chief copy = dept.getChief();
        copy.setName("Hacker");

        System.out.println("\n=== ТЕСТ 3: Изменение копии из геттера не влияет на Department ===");
        System.out.println("Chief в Department: " + dept.getChief().getName());

        // 4. Геттер возвращает новые объекты при каждом вызове
        System.out.println("\n=== ТЕСТ 4: Геттер возвращает новые объекты ===");
        System.out.println("Первый вызов: " + System.identityHashCode(dept.getChief()));
        System.out.println("Второй вызов: " + System.identityHashCode(dept.getChief()));
        System.out.println("Объекты разные? " +
                (dept.getChief() != dept.getChief()));

        System.out.println("\n=== ИТОГ: Department - иммутабельный ===");
    }
}