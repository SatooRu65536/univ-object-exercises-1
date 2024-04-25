import java.util.Scanner;

public class MessageInput {
    public static void main(String[] args) {
        System.out.println("こんにちは、メッセージをどうぞ");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        System.out.println("メッセージを受信しました");
        System.out.println("----");
        System.out.println(message);
        System.out.println("----");
    }
}
