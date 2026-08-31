package hometask.task_3.decorator;

import hometask.task_3.builder.Transaction;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Декоратор для ограничения количества транзакций
 */
public class LimitDecorator extends AbstractDecorator {

    private final int limit;

    public LimitDecorator(Requester requester, int limit) {
        super(requester);
        if (limit <= 0) {
            throw new IllegalArgumentException("limit должен быть больше 0");
        }
        this.limit = limit;
    }

    @Override
    public List<Transaction> request(List<Transaction> list) {
        return list.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }
}