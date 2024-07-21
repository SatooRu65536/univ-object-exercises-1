package jp.ac.ait.k23075;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileArchiver {
    public static void main(String[] args) throws Exception {
        String inputPath = "sore-web-dedekimasu.gif";
        String outputPath = inputPath + ".zip";

        compress(Path.of(inputPath), Path.of(outputPath));
    }

    /**
     * 指定されたファイルをZIP形式で圧縮する
     * 
     * @param inputPath  圧縮対象のファイルのパス
     * @param outputPath 圧縮後のファイルのパス
     */
    private static void compress(Path inputPath, Path outputPath) {
        if (!Files.exists(inputPath)) {
            System.out.println("ファイルが存在しません");
            return;
        }

        try {
            // Stream を作成
            ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(outputPath));
            InputStream is = Files.newInputStream(inputPath);

            // 
            ZipEntry zipEntry = new ZipEntry(inputPath.getFileName().toString());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();
            zos.close();
            is.close();

            System.out.println("圧縮が完了しました");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("圧縮中にエラーが発生しました");
        }
    }
}
