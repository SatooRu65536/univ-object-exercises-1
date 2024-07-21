package jp.ac.ait.k23075;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

class JpegCrasher {
    /**
     * メインメソッド
     */
    public static void main(String[] args) {
        String inputFilePath = args.length > 1 ? args[0] : "Baboon.jpg";
        String outputFilePath = args.length > 1 ? args[0] : "Baboon_out.jpg";
        int challenge = args.length > 2 ? Integer.parseInt(args[2]) : 15;

        crash(inputFilePath, outputFilePath, challenge);
    }

    /**
     * 入力されたファイルのランダムな1Byteをランダムな1bit加算で置き換えることでファイルをクラッシュさせる
     * 
     * @param input_filePath
     * @param output_filePath
     * @param challenge
     */
    public static void crash(String input_filePath, String output_filePath, int challenge) {
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Path.of(input_filePath));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        for (int i = 0; i < challenge; i++) {
            int index = new Random().nextInt(bytes.length);
            byte value = bytes[index];
            byte newValue = (byte) ((int) value + (int) value & 0xFF);
            bytes[index] = newValue;
        }

        try {
            Files.write(Path.of(output_filePath), bytes, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println("ファイルの書き込みに失敗しました");
        }
    }
}
