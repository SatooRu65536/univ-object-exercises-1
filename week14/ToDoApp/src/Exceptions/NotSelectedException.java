package Exceptions;

public class NotSelectedException extends Exception {
    public NotSelectedException(String message) {
        super(message);
    }

    public NotSelectedException() {
        super("選択されていません");
    }

    public NotSelectedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSelectedException(Throwable cause) {
        super(cause);
    }

    public NotSelectedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
