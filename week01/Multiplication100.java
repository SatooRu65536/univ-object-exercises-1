import java.util.Scanner;

public class Multiplication100 {
    public static void main(String[] args) {
        System.out.println("整数値を入力してください");
        Scanner scanner = new Scanner(System.in);
        String numberStr = scanner.nextLine();

        int number = Integer.parseInt(numberStr);
        System.out.println("計算結果：" + number * 100);
    }
}
