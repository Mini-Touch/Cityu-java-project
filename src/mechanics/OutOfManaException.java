package mechanics;

public class OutOfManaException extends RuntimeException {
    public OutOfManaException(String message) {
        super(message);
    }
}