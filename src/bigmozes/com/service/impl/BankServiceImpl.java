package bigmozes.com.service.impl;

import bigmozes.com.lib.Inject;
import bigmozes.com.model.Account;
import bigmozes.com.service.AccountService;
import bigmozes.com.service.AuthenticationManager;
import bigmozes.com.service.BankService;
import bigmozes.com.service.LogService;

import java.math.BigDecimal;
import java.util.Optional;

public class BankServiceImpl implements BankService {
    @Inject
    private AccountService accountService;
    @Inject
    private AuthenticationManager authenticationManager;
    @Inject
    private LogService logService;

    @Override
    public void transfer(String accountFrom, String accountTo, BigDecimal amount) {
        logService.log("Method 'transfer' was called");
        Optional<Account> sender = accountService.findByNumber(accountFrom);
        Optional<Account> receiver = accountService.findByNumber(accountTo);
        if (sender.isEmpty() || receiver.isEmpty()) {
            throw new RuntimeException("Cannot send money from " + accountFrom + " to " + accountTo);
        }
        if (!authenticationManager.hasPermission(accountFrom)) {
            System.out.println("You can't send money");
        }
        if (sender.get().getBalance().compareTo(amount) < 0) {
            System.out.println("Not enough money");
        }
    }
}
