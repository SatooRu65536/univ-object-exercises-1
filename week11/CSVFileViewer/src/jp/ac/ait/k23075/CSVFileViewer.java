package jp.ac.ait.k23075;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class CSVFileViewer {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("ファイルパスを入力してください: ");
        String filepath = sc.nextLine();

        if (!Files.isReadable(Path.of(filepath))) {
            System.out.println("ファイル読み込めませんでした");
            return;
        }

        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filepath));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        int lineCount = 0;
        for (String line : lines) {
            String[] cols = line.split(",", -1);

            System.out.print(++lineCount + ":\t");
            int colCount = 0;
            for (String col : cols) {
                System.out.print(++colCount + ":" + col + "\t");
            }
            System.out.print("\n");
        }
    }
}
