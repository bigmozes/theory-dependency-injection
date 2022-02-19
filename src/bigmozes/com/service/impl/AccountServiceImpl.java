package bigmozes.com.service.impl;

import bigmozes.com.model.Account;
import bigmozes.com.model.User;
import bigmozes.com.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    private static final List<Account> accounts = new ArrayList<>();

    static {
        User bob = new User("Bob", 23);
        User alice = new User("Alice", 19);
        Account bobAccount = new Account("1234", bob);
        Account aliceAccount = new Account("5678", alice);
        accounts.add(bobAccount);
        accounts.add(aliceAccount);
    }

    @Override
    public Optional<Account> findByNumber(String accountNumber) {
        return accounts.stream().filter(a -> a.getAccountNumber().equals(accountNumber)).findFirst();
    }

    @Override
    public Optional<Account> findByUser(String userName) {
        return accounts.stream().filter(a -> a.getOwner().getName().equals(userName)).findFirst();
    }
}
