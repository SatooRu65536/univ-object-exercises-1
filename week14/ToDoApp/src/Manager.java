import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Exceptions.DateParseException;
import Exceptions.NotEnteredException;
import Exceptions.NotSelectedException;

public class Manager {
    private final JList<String> groupList;
    private final JList<String> todoList;

    private final ArrayList<ToDoGroup> groups = new ArrayList<>();
    private Mode mode;
    private Alert alert;

    public Manager(JPanel body, JList<String> groupList, JList<String> todoList, Mode mode) {
        this.alert = new Alert(body);
        this.groupList = groupList;
        this.todoList = todoList;
        this.mode = mode;
    }

    /**
     * グループを追加する
     * 
     * @param groupName グループ名
     */
    public void addGroup(JTextField groupNameField) {
        String groupName = groupNameField.getText();

        if (groupName.isEmpty()) {
            alert.showGroupNotEntered();
            return;
        }

        ToDoGroup newGroup = new ToDoGroup(todoList, groupName);
        groups.add(newGroup);
        updateGroupList();

        groupNameField.setText("");
    }

    /**
     * グループを削除する
     */
    public void removeGroup() {
        try {
            int index = getSelectedIndex(groupList);
            ToDoGroup group = groups.get(index);
            if (alert.confirm("確認", "本当に削除しますか？\nグループ名: " + group.getName())) {
                groups.remove(index);
                updateGroupList();
            }
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        }
    }

    /**
     * グループ名を編集するモードに切り替える
     * 
     * @param groupNameField
     */
    public void handleGroupEditBtn() {
        try {
            int index = getSelectedIndex(groupList);
            ToDoGroup group = groups.get(index);
            mode.toGroupEditMode(group);
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        }
    }

    /**
     * グループ名を変更する
     * 
     * @param groupNameField
     */
    public void editGroup(JTextField groupNameField) {
        try {
            int index = getSelectedIndex(groupList);
            ToDoGroup group = groups.get(index);
            group.setName(groupNameField.getText());
            updateGroupList();
            mode.toGroupNormalMode();
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        }
    }

    /**
     * ToDo を追加する
     * 
     * @param groupIndex  グループのインデックス
     * @param title       タイトル
     * @param deadlineStr 期限(yyyy-MM-dd hh:mm)
     */
    public void addTodo(JTextField todoTitleField, JTextField todoDeadlineField) {
        String title = todoTitleField.getText();
        String deadlineStr = todoDeadlineField.getText();

        try {
            int groupIndex = getSelectedIndex(groupList);
            ToDo todo = new ToDo(title, deadlineStr);
            groups.get(groupIndex).add(todo).showList();
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        } catch (NotEnteredException e) {
            alert.showTitleNotEntered();
        } catch (DateParseException e) {
            alert.showDateParseError();
        }
    }

    /**
     * ToDo を削除する
     */
    public void removeTodo() {
        try {
            int groupIndex = getSelectedIndex(groupList);
            int todoIndex = getSelectedIndex(todoList);
            ToDoGroup group = groups.get(groupIndex);
            if (alert.confirm("確認", "本当に削除しますか？\nタイトル: " + group.getTodos().get(todoIndex).getTitle())) {
                group.remove(todoIndex).showList();
            }
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        }
    }

    /**
     * ToDoを編集するモードに切り替える
     * 
     * @param todoTitleField
     */
    public void handleTodoEditBtn() {
        try {
            int groupIndex = getSelectedIndex(groupList);
            int todoIndex = getSelectedIndex(todoList);
            ToDo todo = groups.get(groupIndex).getTodos().get(todoIndex);
            mode.toTodoEditMode(todo);
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        }
    }

    public void editTodo(JTextField todoTitleField, JTextField todoDeadlineField) {
        try {
            int groupIndex = getSelectedIndex(groupList);
            int todoIndex = getSelectedIndex(todoList);
            ToDo todo = groups.get(groupIndex).getTodos().get(todoIndex);
            todo.setTitle(todoTitleField.getText());
            todo.setDeadline(todoDeadlineField.getText());
            groups.get(groupIndex).showList();
            mode.toTodoNormalMode();
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        } catch (DateParseException e) {
            alert.showDateParseError();
        }
    }

    /**
     * 選択されたグループが変更されたときの処理
     */
    public void handleSelectedGroupChanged() {
        int index = groupList.getSelectedIndex();
        if (index == -1) {
            return;
        }
        groups.get(index).showList();
    }

    /**
     * グループリストを表示する
     */
    private void updateGroupList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (ToDoGroup group : groups) {
            model.addElement(group.getName());
        }
        groupList.setModel(model);
    }

    /**
     * 選択されたインデックスを取得する
     * 
     * @param list
     * @return
     * @throws NotSelectedException
     */
    private int getSelectedIndex(JList<String> list) throws NotSelectedException {
        int index = list.getSelectedIndex();

        if (index == -1) {
            throw new NotSelectedException();
        }

        return index;
    }
}
