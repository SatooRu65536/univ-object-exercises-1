package jp.ac.ait.k23075;

import java.util.Scanner;

public class Kadai2 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("パスワードを入力してください > ");
            String input = sc.nextLine();
            PasswordManager.validate(input);
        } catch (PasswordRulesViolationException e) {
            System.out.printf("パスワードのルール基準を満たしていません。%s \n", e.getMessage());
        }
    }
}
