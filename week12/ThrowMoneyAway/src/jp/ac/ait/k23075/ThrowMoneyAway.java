package jp.ac.ait.k23075;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class ThrowMoneyAway {

    // 入力用Scanner
    private static final Scanner sc = new Scanner(System.in);
    private static final Path dataPath = Path.of("data.dat");

    public static void main(String[] args) {
        ChargeData data = loadChargeData(dataPath);

        // データがない場合は初期設定を行う
        if (data == null) {
            int price = 300;
            double ssr = 1.0;
            System.out.println("課金データが見つかりませんでした。初期設定を行います。");

            try {
                System.out.println("ガチャの基本データ:課金単価を整数値で入力してください。");
                price = Integer.parseInt(sc.nextLine());
                System.out.println("ガチャの基本データ:SSRの出現確率を実数値で入力してください。");
                ssr = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("入力エラー");
                // 例外発生時は初期値とする(めんどうなのでここは何もしない)
            }
            // ガチャの基本データを設定して初期化
            data = new ChargeData(price, ssr);
        }

        // ガチャデータの表示
        System.out.println("課金単価: " + data.getUnitPrice() + "円");
        System.out.println("SSRの確率: " + data.getChanceOfWinning() + "%");

        // SSRが出るか、諦めるまで無限ループ
        while (doChallenge(data)) {
            saveChargeData(dataPath, data);
        }

        // ガチャへの無謀な挑戦の結果表示
        System.out.println("課金回数: " + data.getChallengeCount() + "回");
        System.out.println("課金額合計: " + data.getChargedTotal() + "円");
        System.out.println("SSR出現総数: " + data.getHitCount() + "回");

        // 当選していようがいまいが、"data.dat"に課金のデータを保存する
        saveChargeData(dataPath, data);

    }

    /**
     * 指定したファイルからChargeDataを読み込む
     * 
     * @param path
     * @return
     */
    private static ChargeData loadChargeData(Path path) {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            var data = ois.readObject();
            if (data instanceof ChargeData) {
                return (ChargeData) data;
            }
            return null;
        } catch (ClassNotFoundException | InvalidClassException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 
     * @param path
     * @param data
     * @return
     */
    private static void saveChargeData(Path path, ChargeData data) throws UncheckedIOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(data);
            oos.flush();
        } catch (IOException e) {
            System.out.println("データファイルの保存に失敗しました。");
        }
    }

    /**
     * ガチャ引くぞ！
     * 
     * @param data 課金データを渡す
     * @return trueで継続、falseで終了
     */
    private static boolean doChallenge(ChargeData data) {
        return doChallenge(data, true);
    }

    /**
     * ガチャ引くぞ！
     * 
     * @param data         課金データを渡す
     * @param addDirection 操作選択やガチャを引く演出を入れるかどうか
     * @return trueで継続、falseで終了
     */
    private static boolean doChallenge(ChargeData data, boolean addDirection) {
        if (addDirection) {
            System.out.println("操作を選んでください。\n(1:課金してガチャを引く, それ以外:諦める)");

            int command = 0;
            try {
                command = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                // 例外発生時は諦める選択とする
                command = 0;
            }

            if (command != 1) {
                System.out.println("「諦める」を選択しました。お疲れさまでした。");
                return false;
            }

            System.out.println("「課金してガチャを引く」を選択しました。");

            // 演出のための待ち時間
            for (int i = 0; i < 5; i++) {
                System.out.print("* ");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        }

        // ガチャを引く
        if (data.challenge()) {
            System.out.println("ガチャ結果: SSR の景品が出ました。");
            System.out.println("おめでとうございます！お疲れさまでした。");
            return false; // SRRが出たのでその時点で終了
        }

        // ガチャの結果(SSRじゃなければ当たりじゃない)
        String[] rare = { "SR++", "SR+", "SR", "R++", "R+", "R", "N++", "N+", "N" };
        System.out.println("ガチャ結果: " + rare[new Random().nextInt(rare.length)]);

        // trueを返すことで挑戦継続
        return true;
    }
}
