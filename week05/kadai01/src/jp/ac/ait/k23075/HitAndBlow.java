package jp.ac.ait.k23075;

import java.util.Scanner;

public class HitAndBlow {
    public static void main(String[] args) {
        // ゲームを初期化
        Manager app = new Manager();

        // デバッグ用: 回答を表示
        // String answer = app.getAnswer().get();
        // System.out.println("答え：" + answer);

        // スキャナーを初期化
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 入力を受け付ける
            System.out.print("input " + Answer.DIGITS + " numbers : ");
            String inputString = scanner.nextLine();

            // 入力値が数字か
            if (!StringUtilities.isUnsignedInteger(inputString)) {
                System.out.println("数字でない文字列が含まれているため終了します。");
                break;
            }

            // 入力値の桁数が正しいか
            if (inputString.length() != Answer.DIGITS) {
                System.out.println(Answer.DIGITS + "桁以外の数字が入力されているため終了します。");
                break;
            }

            // 結果を判定
            Response res = app.solve(inputString);

            // 正解した場合
            if (res.getHit() == Answer.DIGITS) {
                int count = app.getCount();
                System.out.println("正解です！");
                System.out.println("正解までにかかった回数：" + count);
                break;
            }

            // 不正解の場合
            int hit = res.getHit();
            int blow = res.getBlow();
            System.out.println("Hit: " + hit + ", Blow: " + blow);
        }

        scanner.close();
    }
}
