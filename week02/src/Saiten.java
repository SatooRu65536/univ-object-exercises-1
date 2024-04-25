import java.util.Scanner;

public class Saiten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("テストの点数を入力してください。");
        String scoreStr = scanner.nextLine();
        int scoreNum = Integer.parseInt(scoreStr);

        if (scoreNum < 0 || scoreNum > 100) {
            System.out.println("入力された値は点数として正しくありません。");
            return;
        }
        if (scoreNum >= 60) {
            System.out.println("合格です。おめでとう！");
        } else if (scoreNum >= 20) {
            System.out.println("不合格です。再テストを行いましょう！");
        } else {
            System.out.println("不合格です。来年もう一年頑張りましょう。100");
        }
    }
}
