package MAINS;

public class CancelationException extends RuntimeException {
    public CancelationException() {
        super("The Action was Canceled");
    }
}
