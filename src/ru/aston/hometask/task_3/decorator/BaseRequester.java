package hometask.task_3.decorator;

import hometask.task_3.builder.Transaction;
import java.util.List;

public class BaseRequester implements Requester {

    @Override
    public List<Transaction> request(List<Transaction> list) {
        if (list == null) {
            throw new IllegalArgumentException("list не должен быть null");
        }
        return list;
    }
}