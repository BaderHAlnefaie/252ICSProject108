package MAINS;
public class ValidationException extends Exception {
    // Contructor
    public ValidationException(String msg) {
        super("\n" + msg);
    }
}
