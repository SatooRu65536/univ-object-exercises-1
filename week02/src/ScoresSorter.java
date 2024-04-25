public class ScoresSorter {
    public static void main(String[] args) {
        String[] names = {"佐藤一郎", "鈴木次郎", "高橋三郎", "田中四郎", "伊藤五郎", "渡辺六郎", "山本七子", "中村八郎", "小林九", "加藤十子"};
        int[][] scores = {
                {100, 30, 50, 40, 50, 60, 70, 80, 95, 10},
                {30, 55, 45, 60, 65, 50, 80, 25, 100, 35},
                {90, 75, 35, 90, 65, 60, 80, 25, 0, 20},
                {10, 85, 25, 70, 90, 80, 60, 50, 40, 30},
                {60, 40, 30, 50, 70, 70, 70, 70, 15, 55},
        };

        int[] sumScores = new int[10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                sumScores[i] += scores[j][i];
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (sumScores[i] < sumScores[j]) {
                    int tmp = sumScores[i];
                    sumScores[i] = sumScores[j];
                    sumScores[j] = tmp;

                    String tmpName = names[i];
                    names[i] = names[j];
                    names[j] = tmpName;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(names[i] + ":" + sumScores[i]);
        }
    }
}
