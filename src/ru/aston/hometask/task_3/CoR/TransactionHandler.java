package hometask.task_3.CoR;

import hometask.task_3.builder.Transaction;

public abstract class TransactionHandler {

    protected TransactionHandler nextHandler;

    public TransactionHandler setNext(TransactionHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    public boolean handle(Transaction transaction) {
        boolean result = process(transaction);

        if (result && nextHandler != null) {
            return nextHandler.handle(transaction);
        }

        return result;
    }

    protected abstract boolean process(Transaction transaction);
}