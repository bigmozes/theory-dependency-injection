package bigmozes.com.service.impl;

import bigmozes.com.service.LogService;

public class LogServiceImpl implements LogService {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
