import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class HtmlGetter extends JFrame {
    private JTextField urlField;
    private JButton getBtn;
    private JButton saveBtn;
    private JTextArea responseArea;
    private JPanel panel1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HtmlGetter().setVisible(true));
    }

    public HtmlGetter() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setContentPane(panel1);

        // 取得ボタンを押された場合
        getBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                String url = urlField.getText();
                String res = sendRequest(url);
                responseArea.setText(res);
            });
        });

        // 保存ボタンを押された場合
        saveBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(this::saveHtml);
        });
    }

    /**
     * 指定されたURLにリクエストを送信する
     *
     * @param url URL
     * @return レスポンス
     */
    private String sendRequest(String url) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return "";
        }
    }

    /**
     * ファイルを保存する
     */
    private void saveHtml() {
        JFileChooser home = new JFileChooser(System.getProperty("user.home"));

        home.setSelectedFile(new File("index.html"));
        int selected = home.showSaveDialog(this);

        if (selected == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "キャンセルしました");
        } else if (selected != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "エラーが発生しました");
        }

        String text = responseArea.getText();
        Path path = home.getSelectedFile().toPath();

        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            bw.write(text);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "ファイルを保存できませんでした");
        }
    }
}
