package hometask.task_3.adapter;

import hometask.task_3.builder.Transaction;
import java.util.List;

public interface TransactionSaver {
    void save(List<Transaction> transactions);
}