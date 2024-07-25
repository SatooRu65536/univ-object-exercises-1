import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        groups.addAll(getSavedToDoGroup());
        getCompletedGroup();
        showGroupList();
    }

    private ToDoGroup getCompletedGroup() {
        // 完了済みのグループを持つか
        ToDoGroup completedGroup = groups.stream().filter(g -> g.isCompletedGroup()).findFirst().orElse(null);
        if (completedGroup != null) {
            return completedGroup;
        }

        ToDoGroup newGroup = new ToDoGroup("完了済み", true);
        groups.add(newGroup);

        return newGroup;
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

        ToDoGroup newGroup = new ToDoGroup(groupName);
        groups.add(newGroup);
        showGroupList();

        groupNameField.setText("");
        save();
    }

    /**
     * グループを削除する
     */
    public void removeGroup() {
        try {
            int index = getSelectedIndex(groupList);
            ToDoGroup group = groups.get(index);

            if (group.isCompletedGroup()) {
                alert.showCannnotRemoveCompletedGroup();
                return;
            }

            if (alert.confirm("確認", "本当に削除しますか？\nグループ名: " + group.getName())) {
                groups.remove(index);
                showGroupList();
            }
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        }

        save();
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
     * 完了した ToDo を移動する
     */
    public void handleTodoCompletedBtn() {
        try {
            int groupIndex = getSelectedIndex(groupList);
            int todoIndex = getSelectedIndex(todoList);
            ToDoGroup group = groups.get(groupIndex);
            ToDoGroup completedGroup = getCompletedGroup();
            ToDo todo = group.getTodos().get(todoIndex);

            completedGroup.add(todo);
            group.remove(todoIndex);

            showToDoList(group.getTodos());
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        }

        save();
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
            showGroupList();
            mode.toGroupNormalMode();
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        }

        save();
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
            var todos = groups.get(groupIndex).add(todo).getTodos();
            showToDoList(todos);
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        } catch (NotEnteredException e) {
            alert.showTitleNotEntered();
        } catch (DateParseException e) {
            alert.showDateParseError();
        }

        save();
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
                var todos = group.remove(todoIndex).getTodos();
                showToDoList(todos);
            }
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        }

        save();
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
            var todos = groups.get(groupIndex).getTodos();
            showToDoList(todos);
            mode.toTodoNormalMode();
        } catch (NotSelectedException e) {
            alert.showGroupNotSelected();
        } catch (DateParseException e) {
            alert.showDateParseError();
        }

        save();
    }

    /**
     * 選択されたグループが変更されたときの処理
     */
    public void handleSelectedGroupChanged() {
        int index = groupList.getSelectedIndex();
        if (index == -1) {
            return;
        }
        var todos = groups.get(index).getTodos();
        showToDoList(todos);
    }

    /**
     * グループリストを表示する
     */
    private void showGroupList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (ToDoGroup group : groups) {
            model.addElement(group.getName());
        }
        groupList.setModel(model);
    }

    /**
     * ToDo のリストを表示する
     */
    public void showToDoList(ArrayList<ToDo> todos) {
        DefaultListModel<String> model = new DefaultListModel<>();

        // todos をソートする
        Collections.sort(todos, new Comparator<ToDo>() {
            @Override
            public int compare(ToDo o1, ToDo o2) {
                return o1.getDeadline().compareTo(o2.getDeadline());
            }
        });

        for (ToDo todo : todos) {
            model.addElement(todo.toString());
        }
        todoList.setModel(model);
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

    /**
     * シリアライズして保存する
     */
    private void save() {
        try (FileOutputStream fileOut = new FileOutputStream("todos.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(groups);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * デシリアライズして読み込む
     */
    @SuppressWarnings("unchecked")
    private ArrayList<ToDoGroup> getSavedToDoGroup() {
        try (FileInputStream fileIn = new FileInputStream("todos.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Object obj = in.readObject();

            if (obj instanceof ArrayList<?> genericList) {
                if (!genericList.isEmpty() && genericList.get(0) instanceof ToDoGroup) {
                    return (ArrayList<ToDoGroup>) obj;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return groups;
    }

}
