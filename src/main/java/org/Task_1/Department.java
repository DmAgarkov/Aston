package org.Task_1;

public final class Department {

    private final String name;
    private final Chief chief;

    public Department(String name, Chief chief) {
        this.name = name;
        this.chief = chief.copy();
    }

    public String getName() {
        return name;
    }

    public Chief getChief() {
        return chief.copy();
    }

}
