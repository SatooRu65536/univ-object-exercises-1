import java.util.Random;

public class Answer {

    /**
     * 数値の桁数（final修飾子を使い、再代入を禁止させています。定数のようなものです）
     */
    public static final int DIGITS = 3;

    /**
     * 答え（文字列で管理しています）
     */
    private String numbers;

    /**
     * コンストラクタで答えの初期化
     */
    public Answer() {
        // 答えの生成を行う
        randomize();
    }

    /**
     * 答えを取得する
     * 
     * @return
     */
    public String get() {
        return numbers;
    }

    /**
     * 答えをランダム並び替える
     */
    public void randomize() {
        Random r = new Random();
        var n = r.nextInt((int)Math.pow(10, DIGITS));
        numbers = String.valueOf(n);
    }
}
