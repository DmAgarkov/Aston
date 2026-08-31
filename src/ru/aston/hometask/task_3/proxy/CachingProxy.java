package hometask.task_3.proxy;

import hometask.task_3.builder.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingProxy implements TransactionService {

    private final TransactionService realService;

    private List<Transaction> cachedTransactions;
    private boolean cacheValid = false;

    private final Map<String, Transaction> transactionCache = new HashMap<>();

    public CachingProxy(TransactionService realService) {
        this.realService = realService;
        System.out.println("Создан кэширующий прокси");
    }

    @Override
    public List<Transaction> getTransactions() {
        if (cacheValid && cachedTransactions != null) {
            System.out.println("Возвращаем кэшированный список (" +
                    cachedTransactions.size() + " транзакций)");
            return cachedTransactions;
        }

        System.out.println("Кэш пуст. Загружаем из реального сервиса...");
        List<Transaction> result = realService.getTransactions();

        this.cachedTransactions = result;
        this.cacheValid = true;

        result.forEach(t -> transactionCache.put(t.getId(), t));

        System.out.println("Загружено " + result.size() + " транзакций");
        return result;
    }

    @Override
    public Transaction getTransactionById(String id) {
        if (transactionCache.containsKey(id)) {
            System.out.println("Транзакция " + id + " найдена в кэше");
            return transactionCache.get(id);
        }

        System.out.println("Транзакция " + id + " не найдена в кэше. Загружаем...");
        Transaction transaction = realService.getTransactionById(id);

        if (transaction != null) {
            transactionCache.put(id, transaction);
            System.out.println("Транзакция " + id + " добавлена в кэш");
        } else {
            System.out.println("Транзакция " + id + " не найдена");
        }

        return transaction;
    }

    public void clearCache() {
        System.out.println("Очистка кэша...");
        cachedTransactions = null;
        cacheValid = false;
        transactionCache.clear();
        System.out.println("Кэш очищен");
    }

    public void invalidateListCache() {
        System.out.println("Инвалидация кэша списка...");
        cacheValid = false;
        System.out.println("Кэш списка инвалидирован");
    }

    public void evict(String id) {
        if (transactionCache.remove(id) != null) {
            System.out.println("Транзакция " + id + " удалена из кэша");
        }
    }

    public boolean isCached(String id) {
        return transactionCache.containsKey(id);
    }
}