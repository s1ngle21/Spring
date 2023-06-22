package spring_core.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoggerService {
    private final Logger Logger = java.util.logging.Logger.getLogger(LoggerService.class.getName());

    public void log(String message) {
        Logger.info(message);
    }
}
