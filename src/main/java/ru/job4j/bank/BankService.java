package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    /**
     * Поле, содержащее всех пользователей с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод, позволяющий добавлять нового пользователя
     * содержит проверку, если пользователь уже есть, то нового добавлять не нужно
     * метод putIfAbsent по параметру user создаст значение new ArrayList<Account>()
     * @param user
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод, позволяющий удалять пользователя
     * по уникальному для каждого пользователя параметру passport
     * метод remove удаляет по ключу
     * @param passport
     */
    public void deleteUser(String passport) {
            users.remove(new User(passport, null));
    }

    /**
     * Метод, добавляющий новый счет к пользователю
     * если пользователь найден и такого счета еще нет, добавляет
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> usersAccounts = users.get(user);
            if (!usersAccounts.contains(account)) {
                usersAccounts.add(account);
            }
        }
    }

    /**
     * Метод реализует поиск пользователя по паспорту
     * если ничего не найдено, вернет значение null
     * @param passport
     * @return
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод реализующий поиск по реквизитам
     * певым этапом - поиск по паспорту, если есть такой пользователь,
     * производит поиск из списка всех счетов этого пользователя
     * @param passport
     * @param requisite
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * если исходный счет и счет назначения найдены, и при этом баланс исходного счета
     * позволяет перевести зананную сумму, то - true
     * иначе - false
     * @param sourcePassport
     * @param sourceRequisite
     * @param destinationPassport
     * @param destinationRequisite
     * @param amount
     * @return
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null
                && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}