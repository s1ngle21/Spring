package spring_core.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoggerService {
    private final Logger LOGGER = Logger.getLogger(LoggerService.class.getName());

    public void log(String message) {
        LOGGER.info(message);
    }
}
