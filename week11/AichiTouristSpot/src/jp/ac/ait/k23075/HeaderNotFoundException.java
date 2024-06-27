package jp.ac.ait.k23075;

public class HeaderNotFoundException extends Exception {
    public HeaderNotFoundException(String message) {
        super(message);
    }

    public HeaderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HeaderNotFoundException(Throwable cause) {
        super(cause);
    }

    public HeaderNotFoundException() {
        super();
    }
}
