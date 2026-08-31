package hometask.task_3.strategy;

import hometask.task_3.builder.Transaction;

import java.util.List;

public class ReportGenerator {
    private ReportStrategy strategy;

    public ReportGenerator(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    public void generateReport(List<Transaction> transactions) {
        if (strategy == null) {
            System.out.println("Ошибка! Стратегия не выбрана!");
            return;
        }

        strategy.generate(transactions);
    }
}
