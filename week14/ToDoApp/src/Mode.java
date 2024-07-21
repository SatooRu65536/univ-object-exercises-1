import javax.swing.JButton;
import javax.swing.JTextField;

public class Mode {
    private boolean isGroupEditMode = false;
    private boolean isTodoEditMode = false;

    private JButton groupAddBtn;
    private JButton todoAddBtn;

    private JTextField groupNameField;
    private JTextField todoTitleField;

    public Mode(JButton groupAddBtn, JButton todoAddBtn, JTextField groupNameField, JTextField todoTitleField) {
        this.groupAddBtn = groupAddBtn;
        this.todoAddBtn = todoAddBtn;
        this.groupNameField = groupNameField;
        this.todoTitleField = todoTitleField;
    }

    /**
     * グループの編集モードに切り替える
     * 
     * @return
     */
    public boolean isGroupEditMode() {
        return isGroupEditMode;
    }

    /**
     * グループの編集モードに切り替える
     * 
     * @param group グループ
     */
    public void toGroupEditMode(ToDoGroup group) {
        groupAddBtn.setText("変更");
        groupNameField.setText(group.getName());
        this.isGroupEditMode = true;
    }

    /**
     * グループの編集モードを解除する
     */
    public void toGroupNormalMode() {
        this.isGroupEditMode = false;
        groupAddBtn.setText("+");
        groupNameField.setText("");
    }

    /**
     * ToDo の編集モードに切り替える
     * 
     * @return
     */
    public boolean isTodoEditMode() {
        return isTodoEditMode;
    }

    /**
     * ToDo の編集モードに切り替える
     * 
     * @param todo ToDo
     */
    public void toTodoEditMode(ToDo todo) {
        todoAddBtn.setText("変更");
        todoTitleField.setText(todo.getTitle());
        this.isTodoEditMode = true;
    }

    /**
     * ToDo の編集モードを解除する
     */
    public void toTodoNormalMode() {
        this.isTodoEditMode = false;
        todoAddBtn.setText("+");
        todoTitleField.setText("");
    }
}
