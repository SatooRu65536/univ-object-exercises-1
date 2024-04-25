import java.util.ArrayList;

public class ScoresManager {
    public static void main(String[] args) {
        // 学生の点数を管理するリスト
        ArrayList<StudentScores> scores = new ArrayList<>();

        // 標準入力
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("学生の人数を入力してください。");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            StudentScores score = new StudentScores();

            System.out.println("学籍番号を入力してください。");
            score.id = scanner.nextInt();

            System.out.println("名前を入力してください。");
            score.name = scanner.next();

            System.out.println("国語の点数を入力してください。");
            int japaneseScore = scanner.nextInt();
            score.setJapaneseScore(japaneseScore);

            System.out.println("数学の点数を入力してください。");
            score.setMathematicsScore(scanner.nextInt());

            System.out.println("理科の点数を入力してください。");
            score.setScienceScore(scanner.nextInt());

            System.out.println("社会の点数を入力してください。");
            score.setSocialStudiesScore(scanner.nextInt());

            System.out.println("英語の点数を入力してください。");
            score.setEnglishScore(scanner.nextInt());

            scores.add(score);
        }

        for (StudentScores score : scores) {
            System.out.println(score.getInfo());
        }

        scanner.close();
    }
}
