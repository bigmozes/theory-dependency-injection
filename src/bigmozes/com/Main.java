package bigmozes.com;

import bigmozes.com.app.AtmApp;
import bigmozes.com.app.ClientApp;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        ClientApp clientApp = new ClientApp();
        clientApp.login("Bob", "1234");
        clientApp.sendMoney("5678", BigDecimal.valueOf(100));

        AtmApp atmApp = new AtmApp();
        atmApp.login("12345678");
        atmApp.sendMoney("5678", BigDecimal.valueOf(200));
    }
}