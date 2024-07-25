import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Alert {
    private JPanel body;

    public Alert(JPanel body) {
        this.body = body;
    }

    public void showGroupNotSelected() {
        show("グループが選択されていません", "グループを選択してください");
    }

    public void showGroupNotEntered() {
        show("グループ名が入力されていません", "グループ名を入力してください");
    }

    public void showTitleNotEntered() {
        show("タイトルが入力されていません", "タイトルを入力してください");
    }

    public void showDateParseError() {
        show("日付のフォーマットが正しくありません", "yyyy-MM-dd hh:mm の形式で入力してください");
    }

    public void showCannnotRemoveCompletedGroup() {
        show("グループを削除できません", "完了済みのグループは削除できません");
    }

    /**
     * ダイアログを表示する
     * 
     * @param title   タイトル
     * @param message メッセージ
     */
    public void show(String title, String message) {
        JOptionPane.showMessageDialog(
                body,
                message,
                title,
                JOptionPane.INFORMATION_MESSAGE //
        );
    }

    /**
     * 確認ダイアログを表示する
     * 
     * @param title
     * @param message
     * @return
     */
    public boolean confirm(String title, String message) {
        return JOptionPane.showConfirmDialog(
                body,
                message,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION;
    }
}
