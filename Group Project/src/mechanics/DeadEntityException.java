package mechanics;

public class DeadEntityException extends RuntimeException {
    public DeadEntityException(String message) {
        super(message);
    }
}