package bigmozes.com.service.impl;

import bigmozes.com.lib.Component;
import bigmozes.com.service.LogService;

@Component
public class LogServiceImpl implements LogService {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
