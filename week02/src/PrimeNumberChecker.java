import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        System.out.println("整数を入力してください");
        Scanner scanner = new Scanner(System.in);
        String numberStr = scanner.nextLine();

        int number = Integer.parseInt(numberStr);

        if (number <= 1) {
            System.out.println("素数ではありません");
            return;
        }

        for (int n = 2; n <= number / 2; n ++) {
            if (number % n == 0) {
                System.out.println("素数ではありません");
                return;
            }
        }

        System.out.println("素数です");
    }
}
