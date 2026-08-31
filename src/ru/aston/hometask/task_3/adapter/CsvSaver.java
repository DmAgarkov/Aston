package hometask.task_3.adapter;

import hometask.task_3.builder.Transaction;
import java.util.List;

public class CsvSaver {
    public void saveToCsv(List<Transaction> transactions) {
        System.out.println("Сохранено в CSV: " + transactions.size() + " записей");
    }
}