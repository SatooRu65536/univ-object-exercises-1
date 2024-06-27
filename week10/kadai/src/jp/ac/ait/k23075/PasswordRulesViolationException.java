package jp.ac.ait.k23075;

public class PasswordRulesViolationException extends Exception {
    public PasswordRulesViolationException() {
        super();
    }

    public PasswordRulesViolationException(String message) {
        super(message);
    }

    public PasswordRulesViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordRulesViolationException(Throwable cause) {
        super(cause);
    }
}
