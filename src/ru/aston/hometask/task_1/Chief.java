package hometask.task_1;

import java.math.BigDecimal;

public class Chief {

    private String name;
    private BigDecimal salary;


    public Chief(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public Chief(Chief other) {
        if (other == null) throw new IllegalArgumentException("Null object");
        this.name = other.name;
        this.salary = other.salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Chief copy() {
        return new Chief(this);
    }
}
