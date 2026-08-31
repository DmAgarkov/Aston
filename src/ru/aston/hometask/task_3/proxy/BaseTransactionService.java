package hometask.task_3.proxy;

import hometask.task_3.builder.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseTransactionService implements TransactionService {

    private final List<Transaction> transactions;

    public BaseTransactionService() {
        this.transactions = new ArrayList<>();
    }

    public BaseTransactionService(List<Transaction> list) {
        this.transactions = new ArrayList<>();
        transactions.addAll(list);
    }

    @Override
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    @Override
    public Transaction getTransactionById(String id) {
        Optional<Transaction> found = transactions.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();

        return found.orElse(null);
    }
}