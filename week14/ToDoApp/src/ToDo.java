import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Exceptions.DateParseException;
import Exceptions.NotEnteredException;

public class ToDo {
    private String title;
    private Date deadline;

    /**
     * タイトルと期限(Date) を指定して ToDo オブジェクトを生成する
     * 
     * @param title
     * @param deadline
     */
    public ToDo(String title, Date deadline) {
        this.title = title;
        this.deadline = deadline;
    }

    /**
     * タイトルと期限(文字列) を指定して ToDo オブジェクトを生成する
     * 
     * @param title
     * @param deadlineStr
     * @throws IllegalArgumentException
     */
    public ToDo(String title, String deadlineStr) throws NotEnteredException, DateParseException {
        if (title.isEmpty()) {
            throw new NotEnteredException("タイトルが入力されていません");
        }

        this.title = title;
        try {
            setDeadline(deadlineStr);
        } catch (DateParseException e) {
            throw e;
        }
    }

    public String getTitle() {
        return title;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setDeadline(String deadlineStr) throws DateParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date date = dateFormat.parse(deadlineStr);
            this.deadline = date;
        } catch (ParseException e) {
            throw new DateParseException("日付の形式が正しくありません", e);
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return "[" + dateFormat.format(deadline) + "]" + title;
    }
}
