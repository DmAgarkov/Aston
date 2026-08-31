package hometask.task_3.decorator;

public abstract class AbstractDecorator implements Requester {

    private final Requester requester;

    protected AbstractDecorator(Requester requester) {
        if (requester == null) {
            throw new IllegalArgumentException("requester не должен быть null");
        }
        this.requester = requester;
    }
}
