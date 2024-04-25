import java.util.Scanner;

public class AtodashiJanken {
    private  static  String getHand(Integer hand) throws Exception {
        return switch (hand) {
            case 0 -> "グー";
            case 1 -> "チョキ";
            case 2 -> "パー";
            default -> throw new Exception("手が誤っています");
        };
    }

    private static String printJudge(int myself, int yourself) throws Exception {
        int judge = (myself + 3 - yourself) % 3;

        return switch (judge) {
            case 0 -> "あいこ";
            case 1 -> "負け";
            case 2 -> "勝ち";
            default -> throw new Exception("手が誤っています");
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int randomHand = new java.util.Random().nextInt(3);
        try {
            getHand(randomHand);
        } catch (Exception e) {
            System.out.println("エラー");
        }

        System.out.println("何を出しますか？ (0:グー,1:チョキ,2:パー)");
        String handStr = scanner.nextLine();
        int handNum = Integer.parseInt(handStr);

        try {
            getHand(handNum);
        } catch (Exception e) {
            System.out.println("あなたの出した手が判断できません。勝負はしません。");
            return;
        }

        try {
            String judge = printJudge(handNum, randomHand);
            System.out.println(judge);
        } catch (Exception e) {
            System.out.println("勝敗を判断できない手があります");
        }
    }
}
