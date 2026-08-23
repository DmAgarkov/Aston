package hometask.task_1;

public final class Department {

    private final String name;
    private final Chief chief;

    public Department(String name, Chief chief) {
        if (chief == null) throw new IllegalArgumentException("Null object");
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
