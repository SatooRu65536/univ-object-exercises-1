import com.google.gson.Gson;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook extends JFrame {
    private JPanel panel1;
    private JButton saveButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton addButton;
    private JList<String> list1;

    public ArrayList<Address> addressList = new ArrayList<Address>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddressBook().setVisible(true);
        });
    }

    public AddressBook() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setContentPane(panel1);

        addButton.addActionListener(e -> appendAddress());
        saveButton.addActionListener(e -> saveFile());
    }

    /**
     * ファイルを保存する
     */
    private void saveFile() {
        // bookの内容をJSON形式に変換する
        Gson gson = new Gson();
        String jsonText = gson.toJson(addressList);

        JFileChooser home = new JFileChooser(System.getProperty("user.home"));

        // デフォルトのファイル名を指定
        String defaultFileName = "address.json";
        home.setSelectedFile(new File(defaultFileName));
        int selected = home.showSaveDialog(this);

        if (selected == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "キャンセル");
            return;
        }
        if (selected != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "取り消しまたはエラー発生");
            return;
        }

        Path filePath = home.getSelectedFile().toPath();
        try (BufferedWriter bw = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            bw.write(jsonText);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "ファイルを保存する際にエラー発生");
        }
    }

    /**
     * アドレスを追加する
     */
    private void appendAddress() {
        Address address = new Address(textField1.getText(), textField2.getText());
        addressList.add(address);

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Address addr : addressList) {
            model.addElement(addr.getName() + ":" + addr.getPhoneNumber());
        }
        list1.setModel(model);

        textField1.setText("");
        textField2.setText("");
    }

}
