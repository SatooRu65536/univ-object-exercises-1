import java.awt.*;
import javax.swing.*;

public class LightOut extends JFrame {
    private JPanel panel1;
    private JLabel label00;
    private JLabel label01;
    private JLabel label02;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;

    LightManager manager = new LightManager(
            label00, label01, label02, //
            label10, label11, label12, //
            label20, label21, label22, //
            () -> {
                JOptionPane.showMessageDialog(
                        panel1,
                        "GameClear!!",
                        "3x3 LightsOut",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
            });

    public LightOut() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setTitle("k23075 - Lights Out");

        setContentPane(panel1);
    }

    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> {
            new LightOut().setVisible(true);
        });
    }
}
