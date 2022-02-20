package bigmozes.com;

import bigmozes.com.app.AtmApp;
import bigmozes.com.app.ClientApp;
import bigmozes.com.lib.Injector;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // - Dependency Inversion - we should depend on abstraction,
        // i.e. class ClientApp depends on interface BankService,
        // but not on concrete implementation like BankServiceImpl

        // - Dependency Injection - we should initialize dependencies outside
        // - Inversion of Control - someone else should call new

        Injector injector = Injector.getInjector();
        ClientApp clientApp = (ClientApp) injector.getInstance(ClientApp.class);

        clientApp.login("Bob", "1234");
        clientApp.sendMoney("5678", BigDecimal.valueOf(100));

        AtmApp atmApp = (AtmApp) injector.getInstance(AtmApp.class);
        atmApp.login("12345678");
        atmApp.sendMoney("5678", BigDecimal.valueOf(200));
    }
}
