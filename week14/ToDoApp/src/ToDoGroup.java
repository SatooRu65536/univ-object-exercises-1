import java.io.Serializable;
import java.util.ArrayList;

public class ToDoGroup implements Serializable {
    private String name;
    private ArrayList<ToDo> todos = new ArrayList<>();

    public ToDoGroup(String name) {
        this.name = name;
    }

    /**
     * ToDo のリストを取得する
     * 
     * @return ToDo のリスト
     */
    public ArrayList<ToDo> getTodos() {
        return todos;
    }

    /**
     * グループ名を設定する
     * 
     * @param name グループ名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * グループ名を取得する
     * 
     * @return グループ名
     */
    public String getName() {
        return name;
    }

    /**
     * ToDo のリストを設定する
     * 
     * @param todos ToDo のリスト
     * @return ToDoGroup
     */
    public ToDoGroup setTodos(ArrayList<ToDo> todos) {
        this.todos = todos;
        return this;
    }

    /**
     * ToDo を追加する
     * 
     * @param todo ToDo
     * @return ToDoGroup
     */
    public ToDoGroup add(ToDo todo) {
        todos.add(todo);
        return this;
    }

    /**
     * ToDo を削除する
     * 
     * @param todo ToDo
     */
    public void remove(ToDo todo) {
        todos.remove(todo);
    }

    /**
     * ToDo を削除する
     * 
     * @param index インデックス
     */
    public ToDoGroup remove(int index) {
        todos.remove(index);
        return this;
    }
}
