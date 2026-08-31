package hometask.task_3.strategy;

import hometask.task_3.builder.Transaction;

import java.util.List;

public interface ReportStrategy {
    void generate(List<Transaction> transactions);
}
