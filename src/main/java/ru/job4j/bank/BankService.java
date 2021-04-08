package ru.job4j.bank;

import java.util.*;

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
     * Метод принимает на вход пользователя и добавляет его в систему,
     * если такого пользователя еще нет в системе
     * @param user пользователь который доваляется в систему
     */
    public void addUser(User user) {
       users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход паспорт пользователя и новый счет,
     * по паспорту осуществляется поиск пользователя и добаляется новый счет к нему,
     * если пользователь найден в системе
     * @param passport паспорт пользователя к которому добавляется новый счет
     * @param account новый счет который добавляем
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return Optional.ofNullable(users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null));
    }

    /**
     * Метод ищет счет пользователя по реквизитам, осуществляется поиск необходимого пользователя,
     * потом получаем списки счетов этого пользователя и в нем находим нужный счет
     * @param passport паспорт по которому определяем пользователя
     * @param requisite реквизиты по которому определяем нужный счет
     * @return
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return Optional.of(users.get(user.get()).stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null));
        }
        return rsl;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт, если счёт не найден
     * или не хватает денег на счёте с которого переводят, то метод должен вернуть false
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
        Optional<Account> account = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> account1 = findByRequisite(destPassport, destRequisite);
        if (account.isPresent() && account1.isPresent()
                && account.get().getBalance() >= amount) {
            double balance = account.get().getBalance() - amount;
            account.get().setBalance(balance);
            double destBalance = account1.get().getBalance() + amount;
            account1.get().setBalance(destBalance);
            rsl = true;
        }
        return rsl;
    }
}
