package hometask.task_3.adapter;

import hometask.task_3.builder.Transaction;
import java.util.List;

public class CsvAdapter implements TransactionSaver {
    private final CsvSaver csvSaver = new CsvSaver();

    @Override
    public void save(List<Transaction> transactions) {
        csvSaver.saveToCsv(transactions);
    }
}