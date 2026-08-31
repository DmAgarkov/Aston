package hometask.task_3.adapter;

import hometask.task_3.builder.Transaction;
import java.util.List;

public class JsonAdapter implements TransactionSaver {
    private final JsonSaver jsonSaver = new JsonSaver();

    @Override
    public void save(List<Transaction> transactions) {
        jsonSaver.saveToJson(transactions);
    }
}