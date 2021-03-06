package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса
 * @author Denis Illarionov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранениие всех пользователей системы с привязанными к ним счетами в коллекции типа Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему, если такого пользователя еще нет в системе
     * @param user пользователь который доваляется в систему
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход паспорт пользователя и новый счет,
     * по паспорту осуществляется поиск пользователя и добаляется новый счет к нему, если пользователь найден в системе
     * @param passport паспорт пользователя к которому добавляется новый счет
     * @param account новый счет который добавляем
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport паспорт по которому осуществляется поиск
     * @return
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
               return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам, осуществляется поиск необходимого пользователя,
     * потом получаем списки счетов этого пользователя и в нем находим нужный счет
     * @param passport паспорт по которому определяем пользователя
     * @param requisite реквизиты по которому определяем нужный счет
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт,
     * если счёт не найден или не хватает денег на счёте с которого переводят, то метод должен вернуть false
     * @param srcPassport паспорт по которому определяем пользователя
     * @param srcRequisite реквизиты по которому определяем нужный счет с которого переводим деньги
     * @param destPassport паспорт по которому определяем пользователя которому переводим
     * @param destRequisite реквизиты по которому определяем нужный счет на который переводим
     * @param amount сумма которую перечисляем
     * @return
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account account = findByRequisite(srcPassport, srcRequisite);
        Account account1 = findByRequisite(destPassport, destRequisite);
        if (account != null && account1 != null && account.getBalance() >= amount) {
            double balance = account.getBalance() - amount;
            account.setBalance(balance);
            double destBalance = account1.getBalance() + amount;
            account1.setBalance(destBalance);
            rsl = true;
        }
        return rsl;
    }
}
