import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToDoApp extends JFrame {
    private JPanel body;

    private JTextField groupNameField;
    private JTextField todoTitleField;
    private JTextField todoDeadlineField;

    private JList<String> groupList;
    private JList<String> todoList;

    private JButton todoAddBtn;
    private JButton groupAddBtn;

    private final Mode mode = new Mode(groupAddBtn, todoAddBtn, groupNameField, todoTitleField, todoDeadlineField);
    private final Manager manager = new Manager(body, groupList, todoList, mode);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoApp().setVisible(true));
    }

    public ToDoApp() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setContentPane(body);
        setTitle("k23075 - ToDoApp");

        // グループ追加ボタン 押下
        groupAddBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mode.isGroupEditMode()) {
                    manager.editGroup(groupNameField);
                } else {
                    manager.addGroup(groupNameField);
                }
            }
        });
        // タスク追加ボタン 押下
        todoAddBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mode.isTodoEditMode()) {
                    manager.editTodo(todoTitleField, todoDeadlineField);
                } else {
                    manager.addTodo(todoTitleField, todoDeadlineField);
                }
            }
        });
        // グループリスト 選択
        groupList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (e.getValueIsAdjusting()) {
                    return;
                }

                manager.handleSelectedGroupChanged();
            }
        });

        JPopupMenu groupPopupMenu = new JPopupMenu();
        groupPopupMenu.add(createMenuItem("編集", e -> manager.handleGroupEditBtn()));
        groupPopupMenu.add(createMenuItem("削除", e -> manager.removeGroup()));
        // グループリスト 右クリック
        groupList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    groupPopupMenu.show(groupList, e.getX(), e.getY());
                }
            }
        });

        JPopupMenu todoPopupMenu = new JPopupMenu();
        todoPopupMenu.add(createMenuItem("完了", e -> manager.handleTodoCompletedBtn()));
        todoPopupMenu.add(createMenuItem("編集", e -> manager.handleTodoEditBtn()));
        todoPopupMenu.add(createMenuItem("削除", e -> manager.removeTodo()));
        // タスクリスト 右クリック
        todoList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    todoPopupMenu.show(todoList, e.getX(), e.getY());
                }
            }
        });
    }

    private JMenuItem createMenuItem(String text, ActionListener listener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(listener);
        return menuItem;
    }
}
