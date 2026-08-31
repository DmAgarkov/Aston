package hometask.task_3.proxy;

import hometask.task_3.builder.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactions();
    Transaction getTransactionById(String id);
}
