package hometask.task_3.decorator;

import hometask.task_3.builder.Transaction;

import java.util.List;

public interface Requester {
    public List<Transaction> request(List<Transaction> list);
}
