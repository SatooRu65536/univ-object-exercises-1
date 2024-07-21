package Exceptions;

public class NotEnteredException extends Exception {
    public NotEnteredException(String message) {
        super(message);
    }

    public NotEnteredException() {
        super("入力されていません");
    }

    public NotEnteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnteredException(Throwable cause) {
        super(cause);
    }

    public NotEnteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
