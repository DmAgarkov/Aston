package hometask.task_3.CoR;

import hometask.task_3.builder.Transaction;
import java.math.BigDecimal;

public class LimitHandler extends TransactionHandler {

    private final BigDecimal dailyLimit;
    private BigDecimal currentDayTotal = BigDecimal.ZERO;

    public LimitHandler(BigDecimal dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    @Override
    protected boolean process(Transaction transaction) {
        if (transaction.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            BigDecimal expense = transaction.getAmount().abs();

            if (currentDayTotal.add(expense).compareTo(dailyLimit) > 0) {
                System.out.println("Транзакция " + transaction.getId() +
                        " отклонена: лимит " + dailyLimit +
                        " (уже потрачено: " + currentDayTotal + ")");
                return false;
            }

            currentDayTotal = currentDayTotal.add(expense);
            System.out.println("Транзакция " + transaction.getId() +
                    ": лимит OK (осталось: " + dailyLimit.subtract(currentDayTotal) + ")");
        } else {
            System.out.println("Транзакция " + transaction.getId() +
                    ": доход, лимит не проверяется");
        }
        return true;

    }
}