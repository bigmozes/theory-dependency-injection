package bigmozes.com.service.impl;

import bigmozes.com.lib.Inject;
import bigmozes.com.model.Account;
import bigmozes.com.model.User;
import bigmozes.com.service.AccountService;
import bigmozes.com.service.AuthenticationManager;

import java.util.Optional;

public class AuthenticationManagerImpl implements AuthenticationManager {
    @Inject
    private AccountService accountService;
    private User currentUser;

    @Override
    public boolean hasPermission(String accountNumber) {
        Optional<Account> byNumber = accountService.findByNumber(accountNumber);
        User owner = byNumber.get().getOwner();
        if (owner.equals(currentUser)) {
            return true;
        }
        return false;
    }
}
