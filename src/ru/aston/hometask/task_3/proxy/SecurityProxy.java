package hometask.task_3.proxy;

import hometask.task_3.builder.Transaction;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecurityProxy implements TransactionService {

    private final TransactionService realService;
    private final Set<String> allowedUsers = new HashSet<>();
    private String currentUser;

    public SecurityProxy(TransactionService realService) {
        this.realService = realService;
        allowedUsers.add("admin");
        allowedUsers.add("user1");
        allowedUsers.add("user2");
        System.out.println("Создан прокси безопасности");
        System.out.println("Разрешённые пользователи: " + allowedUsers);
    }

    public boolean login(String username) {
        if (allowedUsers.contains(username)) {
            this.currentUser = username;
            System.out.println("Пользователь " + username + " авторизован");
            return true;
        } else {
            System.out.println("Пользователь " + username + " не авторизован");
            return false;
        }
    }

    public void logout() {
        if (currentUser != null) {
            System.out.println("Пользователь " + currentUser + " вышел");
        }
        this.currentUser = null;
    }

    private void checkAccess() {
        if (currentUser == null) {
            throw new SecurityException("Доступ запрещён! Пользователь не авторизован.");
        }
    }

    private void checkAdminAccess() {
        checkAccess();
        if (!"admin".equals(currentUser)) {
            throw new SecurityException("Доступ запрещён! Требуется роль 'admin'.");
        }
    }

    @Override
    public List<Transaction> getTransactions() {
        checkAccess();
        System.out.println("Пользователь " + currentUser + " запрашивает список транзакций");
        return realService.getTransactions();
    }

    @Override
    public Transaction getTransactionById(String id) {
        checkAccess();
        System.out.println("Пользователь " + currentUser + " запрашивает транзакцию " + id);
        return realService.getTransactionById(id);
    }

    public void addUser(String username) {
        checkAdminAccess();
        allowedUsers.add(username);
        System.out.println("Админ " + currentUser + " добавил пользователя: " + username);
    }

    public void removeUser(String username) {
        checkAdminAccess();
        allowedUsers.remove(username);
        System.out.println("Админ " + currentUser + " удалил пользователя: " + username);
    }

    public boolean isAuthenticated() {
        return currentUser != null;
    }

    public String getCurrentUser() {
        return currentUser;
    }
}