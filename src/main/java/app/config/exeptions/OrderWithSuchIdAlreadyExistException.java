package app.config.exeptions;

public class OrderWithSuchIdAlreadyExistException extends RuntimeException {
    public OrderWithSuchIdAlreadyExistException() {
        super();
    }

    public OrderWithSuchIdAlreadyExistException(String message) {
        super(message);
    }

    public OrderWithSuchIdAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
