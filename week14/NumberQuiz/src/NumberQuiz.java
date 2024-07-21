import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumberQuiz extends JFrame {
    private JTextField numberInput;
    private JButton checkButton;
    private JLabel message;
    private JPanel panel;

    private Manager manager = new Manager();
    private boolean reset = false;

    public NumberQuiz() {
        // ウィンドウを閉じたら終了させる
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // ウィンドウ起動位置とウィンドウサイズの指定
        setBounds(100, 100, 320, 160);
        setTitle("k23075 - 数当てゲーム");

        // コンテンツパネル設定 ※IntelliJIDEAでのGUI作成では以下の設定が必須です。
        setContentPane(panel);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reset) {
                    reset = false;
                    manager = new Manager();
                    message.setText("");
                    checkButton.setText("チェック");
                    message.setText("ランダムに決定した3桁の整数値を当てましょう。");
                } else {
                    check(e);
                }
            }
        });
    }

    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> {
            new NumberQuiz().setVisible(true);
        });
    }

    public void check(ActionEvent e) {
        // numberInput の値を取得
        String inputString = numberInput.getText();

        // 入力値が数字か
        if (!StringUtilities.isUnsignedInteger(inputString)) {
            System.out.println("数字でない文字列が含まれています。再度入力してください");
            return;
        }

        // 入力値の桁数が正しいか
        if (inputString.length() != 3) {
            System.out.println("3桁以外の数字が入力されています。再度入力してください");
            return;
        }

        // 結果を判定
        var res = manager.solve(inputString);
        if (res == Manager.Response.CORRECT) {
            int count = manager.getCount();
            message.setText("正解です(試行回数" + count + "回)");
            reset = true;
            checkButton.setText("リセット");
        } else if (res == Manager.Response.UP) {
            message.setText("それより小さい(試行回数" + manager.getCount() + "回)");
        } else {
            message.setText("それより大きい(試行回数" + manager.getCount() + "回)");
        }
    }
}
