package jp.ac.ait.k23075;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Kadai1 {

    // Kadai1 の共通スキャナ
    private static final Scanner sc = new Scanner(System.in);

    /**
     * main
     * 
     * @param args
     */
    public static void main(String[] args) {

        /*
         * 配列の生成
         */

        System.out.print("生成する配列の大きさを入力してください > ");
        String input;

        do {
            input = sc.nextLine();
        } while (!input.matches("^\\d+$"));

        BigInteger bigInteger = new BigInteger(input);
        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            System.out.println("生成する配列の大きさが大きすぎます");
            return;
        }

        // ここは例外処理しない(整数値に変換できる文字列しか来ないはず)
        int size = Integer.parseInt(input);
        int[] arr = createRandomIntArray(size);

        // 生成された配列を画面表示
        System.out.print("生成された配列: ");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

        /*
         * 配列の要素を取り出し
         */

        System.out.print("取り出す配列のインデックスを指定してください > ");

        do {
            input = sc.nextLine();
        } while (!input.matches("^\\d+$"));

        // ここは例外処理しない(整数値に変換できる文字列しか来ないはず)
        int index = Integer.parseInt(input);
        System.out.println("値: " + getValueByIndex(arr, index));
    }

    /**
     * 指定された要素数で各要素がランダムな値を持つ配列を生成して返す
     * 
     * @param size 要素数
     * @return 生成されたランダムな値を持つ配列オブジェクト
     */
    public static int[] createRandomIntArray(int size) {

        if (size <= 0) {
            return new int[0];
        }

        int[] arr = new int[size];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000); // 0〜999まででランダム
        }

        return arr;
    }

    /**
     * 配列とインデックスを渡し、その要素を取り出して返す
     * 
     * @param arr   配列のオブジェクト
     * @param index インデックス
     * @return 取り出した要素
     */
    public static int getValueByIndex(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        } catch (OutOfMemoryError e) {
            return -1;
        } catch (NegativeArraySizeException e) {
            return -1;
        }
    }
}
