package hometask.task_3.adapter;

import hometask.task_3.builder.Transaction;
import java.util.List;

public class JsonSaver {
    public void saveToJson(List<Transaction> transactions) {
        System.out.println("Сохранено в JSON: " + transactions.size() + " записей");
    }
}