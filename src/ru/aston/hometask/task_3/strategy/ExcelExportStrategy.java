package hometask.task_3.strategy;

import hometask.task_3.builder.Transaction;

import java.util.List;

public class ExcelExportStrategy implements ReportStrategy {
    @Override
    public void generate(List<Transaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("transactions не должен быть null");
        }
        System.out.println("Вывод отчёта в формате EXCEL");
    }
}
