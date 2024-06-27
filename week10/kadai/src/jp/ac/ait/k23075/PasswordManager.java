package jp.ac.ait.k23075;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PasswordManager {
    public static boolean validate(String password) throws PasswordRulesViolationException {
        List<Character> symbolList = Arrays.asList(',', '.', '+', '-', '*', '/', '=', '_', '#', '!', '?', '@', ' ');
        Set<String> unusableStringSet = new HashSet<>(Arrays.asList(
                "password", "p@ssw0rd", "p@55w0rd", "qwerty", "asdfgh", "zxcvbn", "abcdef", "123456"));

        // 使用可能な文字か
        if (!password.matches("^[a-zA-Z0-9,.\\+\\-*/=_#!?@ ]+$")) {
            throw new PasswordRulesViolationException("Password contains unusable characters.");
        }
        // 16文字未満
        if (password.length() < 16) {
            throw new PasswordRulesViolationException("Password must be at least 16 characters long.");
        }
        // 128文字超
        if (password.length() > 128) {
            throw new PasswordRulesViolationException("Password must be at most 128 characters long.");
        }
        // 大文字のアルファベット を含む
        if (!password.matches(".*[A-Z].*")) {
            throw new PasswordRulesViolationException("Password must contain at least one uppercase letter.");
        }
        // 小文字のアルファベット を含む
        if (!password.matches(".*[a-z].*")) {
            throw new PasswordRulesViolationException("Password must contain at least one lowercase letter.");
        }
        // 数字 を含む
        if (!password.matches(".*[0-9].*")) {
            throw new PasswordRulesViolationException("Password must contain at least one number.");
        }
        // 記号 を含む
        if (!symbolList.stream().anyMatch(c -> password.contains(c.toString()))) {
            throw new PasswordRulesViolationException("Password must contain at least one symbol.");
        }
        // 容易に推測される文字列を含まない
        if (unusableStringSet.stream().anyMatch(password.toLowerCase()::contains)) {
            throw new PasswordRulesViolationException("Password must not contain easily guessable strings.");
        }

        return true;
    }
}
