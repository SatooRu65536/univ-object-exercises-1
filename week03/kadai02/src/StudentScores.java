import java.util.ArrayList;

public class StudentScores {
    int id;
    String name;
    int[] scores = new int[5];

    public static void main(String[] args) {
        int id = 1;
        String name = "佐藤さとる";
        int[] expectedScores = { 60, 80, 70, 60, 80 };

        StudentScores student = new StudentScores();
        student.setJapaneseScore(expectedScores[0]);
        student.setMathematicsScore(expectedScores[1]);
        student.setScienceScore(expectedScores[2]);
        student.setSocialStudiesScore(expectedScores[3]);
        student.setEnglishScore(expectedScores[4]);

        student.id = id;
        student.name = name;

        System.out.println("学籍番号: " + student.id);
        System.out.println("名前: " + student.name);
        System.out.println("国語: " + student.getJapaneseScore());
        System.out.println("数学: " + student.getMathematicsScore());
        System.out.println("理科: " + student.getScienceScore());
        System.out.println("社会: " + student.getSocialStudiesScore());
        System.out.println("英語: " + student.getEnglishScore());

        System.out.println("");

        System.out.println("合計点: " + student.getTotal());
        System.out.println("平均点: " + student.getAverage());
        System.out.println("最高点: " + student.getHighScore());
        System.out.println("最高点の科目: " + student.getHighScoreSubject());
        System.out.println("最低点: " + student.getLowScore());
        System.out.println("最低点の科目: " + student.getLowScoreSubject());
        System.out.println(student.getInfo());

        System.out.println("\n-------------------------");

        // 期待値と実際の値を比較
        if (student.id == id)
            System.out.println("OK: 学籍番号");
        else
            System.out.println("NG: 学籍番号");

        if (student.name.equals(name))
            System.out.println("OK: 名前");
        else
            System.out.println("NG: 名前");

        if (student.getJapaneseScore() == expectedScores[0])
            System.out.println("OK: 国語");
        else
            System.out.println("NG: 国語");

        if (student.getMathematicsScore() == expectedScores[1])
            System.out.println("OK: 数学");
        else
            System.out.println("NG: 数学");

        if (student.getScienceScore() == expectedScores[2])
            System.out.println("OK: 理科");
        else
            System.out.println("NG: 理科");

        if (student.getSocialStudiesScore() == expectedScores[3])
            System.out.println("OK: 社会");
        else
            System.out.println("NG: 社会");

        if (student.getEnglishScore() == expectedScores[4])
            System.out.println("OK: 英語");
        else
            System.out.println("NG: 英語");
    }

    // 国語の点数を取得
    public int getJapaneseScore() {
        return scores[0];
    }

    // 国語の点数を設定
    public void setJapaneseScore(int value) {
        scores[0] = value;
    }

    // 数学の点数を取得
    public int getMathematicsScore() {
        return scores[1];
    }

    // 数学の点数を設定
    public void setMathematicsScore(int value) {
        scores[1] = value;
    }

    // 理科の点数を取得
    public int getScienceScore() {
        return scores[2];
    }

    // 理科の点数を設定
    public void setScienceScore(int value) {
        scores[2] = value;
    }

    // 社会の点数を取得
    public int getSocialStudiesScore() {
        return scores[3];
    }

    // 社会の点数を設定
    public void setSocialStudiesScore(int value) {
        scores[3] = value;
    }

    // 英語の点数を取得
    public int getEnglishScore() {
        return scores[4];
    }

    // 英語の点数を設定
    public void setEnglishScore(int value) {
        scores[4] = value;
    }

    // 合計点を取得
    public int getTotal() {
        int total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }
        return total;
    }

    // 平均点を取得
    public double getAverage() {
        return (double) getTotal() / scores.length;
    }

    // 最高点を取得
    public int getHighScore() {
        int highScore = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > highScore) {
                highScore = scores[i];
            }
        }
        return highScore;
    }

    // 最低点を取得
    public int getLowScore() {
        int lowScore = 100;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < lowScore) {
                lowScore = scores[i];
            }
        }
        return lowScore;
    }

    private String getSubjectName(int index) {
        String[] subjects = { "国語", "数学", "理科", "社会", "英語" };
        return subjects[index];
    }

    private String getSubjectsByScore(int score) {
        ArrayList<String> subjects = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] != score)
                continue;

            // 点数が一致する科目名を取得
            String subjectName = getSubjectName(i);
            // 点数が一致する科目名をリストに追加
            subjects.add(subjectName);
        }

        return String.join(",", subjects);
    }

    // 最高点の科目を取得
    public String getHighScoreSubject() {
        int highScore = getHighScore();
        return getSubjectsByScore(highScore);
    }

    // 最低点の科目を取得
    public String getLowScoreSubject() {
        int lowScore = getLowScore();
        return getSubjectsByScore(lowScore);
    }

    public String getInfo() {
        int japaneseScore = getJapaneseScore();
        int mathematicsScore = getMathematicsScore();
        int scienceScore = getScienceScore();
        int socialStudiesScore = getSocialStudiesScore();
        int englishScore = getEnglishScore();

        int total = getTotal();
        double average = getAverage();

        int highScore = getHighScore();
        String highScoreSubject = getHighScoreSubject();

        int lowScore = getLowScore();
        String lowScoreSubject = getLowScoreSubject();

        return String.format("%d %s 国語:%d点 数学:%d点 理科:%d点 社会:%d点 英語:%d点 合計:%d点 平均:%.2f点 得意科目:%s(%d点) 苦手科目:%s(%d点)",
                id, name, japaneseScore, mathematicsScore, scienceScore, socialStudiesScore, englishScore, total,
                average, highScoreSubject, highScore, lowScoreSubject, lowScore);
    }
}
