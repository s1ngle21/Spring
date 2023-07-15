package app.exeptions.handler;

import app.exeptions.OrderWithSuchIdAlreadyExistException;
import app.exeptions.OrderWithSuchIdDoesNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNullPointerException (NullPointerException e) {
        LOGGER.error(e.getMessage(), e);
        return new ErrorResponse("This parameter can not be null", HttpStatus.BAD_REQUEST.value());
    }
    @ExceptionHandler(OrderWithSuchIdDoesNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleOrderWithSuchIdDoesNotExistException(OrderWithSuchIdDoesNotExistException e) {
        LOGGER.error(e.getMessage());
        return new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
    @ExceptionHandler(OrderWithSuchIdAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleOrderWithSuchIdAlreadyExistException(OrderWithSuchIdAlreadyExistException e) {
        LOGGER.error(e.getMessage());
        return new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

}
