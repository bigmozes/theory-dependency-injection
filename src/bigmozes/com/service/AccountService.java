package bigmozes.com.service;

import bigmozes.com.model.Account;
import bigmozes.com.model.User;

import java.util.Optional;

public interface AccountService {

    Optional<Account> findByNumber(String accountNumber);

    Optional<Account> findByUser(String userName);
}
