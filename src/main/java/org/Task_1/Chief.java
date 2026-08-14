package org.Task_1;

public class Chief {

    private String name;
    private float salary;


    public Chief(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public Chief(Chief other) { // Копирующий конструктор
        this.name = other.name;
        this.salary = other.salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Chief copy() {
        return new Chief(this);
    }
}
