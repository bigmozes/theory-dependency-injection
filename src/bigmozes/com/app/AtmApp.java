package bigmozes.com.app;

import bigmozes.com.lib.Inject;
import bigmozes.com.model.Account;
import bigmozes.com.model.User;
import bigmozes.com.service.AccountService;
import bigmozes.com.service.BankService;

import java.math.BigDecimal;
import java.util.Optional;

public class AtmApp {
    @Inject
    private BankService bankService;
    @Inject
    private AccountService accountService;
    private User currentUser;

    public void sendMoney(String to, BigDecimal amount) {
        Optional<Account> userAccount = accountService.findByUser(currentUser.getName());
        if (userAccount.isEmpty()) {
            throw new RuntimeException("User does not have an account");
        }
        bankService.transfer(userAccount.get().getAccountNumber(), to, amount);
    }

    public void login(String phoneNumber) {
        // some logic to login user
        this.currentUser = new User("Bob", 23);
    }
}
