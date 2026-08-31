package hometask.task_3.decorator;

import hometask.task_3.builder.Transaction;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingDecorator extends AbstractDecorator {

    private final Comparator<Transaction> comparator;

    public SortingDecorator(Requester requester, Comparator<Transaction> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("comparator не должен быть null");
        }
        super(requester);
        this.comparator = comparator;
    }

    @Override
    public List<Transaction> request(List<Transaction> list) {
        return list.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}