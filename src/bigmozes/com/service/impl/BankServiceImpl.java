package bigmozes.com.service.impl;

import bigmozes.com.model.Account;
import bigmozes.com.service.AccountService;
import bigmozes.com.service.BankService;

import java.math.BigDecimal;
import java.util.Optional;

public class BankServiceImpl implements BankService {
    private AccountService accountService;
    @Override
    public void transfer(String accountFrom, String accountTo, BigDecimal amount) {
        Optional<Account> sender = accountService.findByNumber(accountFrom);
        Optional<Account> receiver = accountService.findByNumber(accountTo);

        if (sender.isEmpty() || receiver.isEmpty()) {
            throw new RuntimeException("Cannot send money from " + accountFrom + " to " + accountTo);
        }

        if (sender.get().getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Not enough money");
        }
    }
}
