package bigmozes.com.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private User owner;
    private String accountNumber;
    BigDecimal balance;

    public Account() {
    }

    public Account(String number, User owner) {
        this.accountNumber = number;
        this.owner = owner;
        this.balance = BigDecimal.valueOf(0);
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(owner, account.owner) && Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, accountNumber, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "owner=" + owner +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
