import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClickCounter extends JFrame {
    private JTextField countField;
    private JButton decrementButton;
    private JButton resetButton;
    private JButton incrementButton;
    private JPanel panel;

    private static int count = 0;

    /**
     * メインメソッド
     * @param args 引数
     */
    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> {
            new ClickCounter().setVisible(true);
        });
    }

    public ClickCounter() {
        // ウィンドウを閉じたら終了させる
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // ウィンドウ起動位置とウィンドウサイズの指定
        setBounds(100, 100, 600, 400);

        setTitle("k23075 - クリックカウンタ");

        // コンテンツパネル設定 ※IntelliJIDEAでのGUI作成では以下の設定が必須です。
        setContentPane(panel);
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                countField.setText(String.valueOf(count));
            }
        });
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                countField.setText(String.valueOf(count));
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = 0;
                countField.setText(String.valueOf(count));
            }
        });
    }
}
