package bigmozes.com.app;

import bigmozes.com.lib.Inject;
import bigmozes.com.service.BankService;

import java.math.BigDecimal;

public class BankOperatorApp {
    @Inject
    private BankService bankService;

    public void sendMoney(String from, String to, BigDecimal amount) {
        bankService.transfer(from, to, amount);
    }
}
