package hometask.task_3.decorator;

import hometask.task_3.builder.Transaction;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringDecorator extends AbstractDecorator {

    private final Predicate<Transaction> predicate;

    public FilteringDecorator(Requester requester, Predicate<Transaction> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("predicate не должен быть null");
        }
        super(requester);
        this.predicate = predicate;
    }

    @Override
    public List<Transaction> request(List<Transaction> list) {
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}