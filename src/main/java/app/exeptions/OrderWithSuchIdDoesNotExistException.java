package app.exeptions;

public class OrderWithSuchIdDoesNotExistException extends RuntimeException{
    public OrderWithSuchIdDoesNotExistException() {
        super();
    }

    public OrderWithSuchIdDoesNotExistException(String message) {
        super(message);
    }

    public OrderWithSuchIdDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
