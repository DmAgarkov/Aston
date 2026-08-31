package hometask.task_3.CoR;

import hometask.task_3.builder.Transaction;
import java.math.BigDecimal;

public class AmountHandler extends TransactionHandler {

    @Override
    protected boolean process(Transaction transaction) {
        if (transaction.getAmount().compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Транзакция " + transaction.getId() +
                    " отклонена: сумма равна нулю");
            return false;
        }

        System.out.println("Транзакция " + transaction.getId() +
                ": сумма прошла проверку (" + transaction.getAmount() + ")");
        return true;
    }
}