package jp.ac.ait.k23075;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AichiTouristSpot {
    private static int getColNumByHeader(String header, String[] targets) {
        String[] headers = header.split(",");
        for (int i = 0; i < headers.length; i++) {
            for (String target : targets) {
                if (headers[i].contains(target)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static List<Spot> getSpotsByFile(Path file) throws FileNotFoundException {
        var spots = new ArrayList<Spot>();

        if (!Files.isReadable(file)) {
            System.out.println("ファイル読み込めませんでした");
            throw new FileNotFoundException("ファイル読み込めませんでした");
        }

        int nameIndex = 0;
        int positionIndex = 0;

        try (Scanner sc = new Scanner(Files.newBufferedReader(file, Charset.forName("ms932")))) {
            if (sc.hasNextLine()) {
                String header = sc.nextLine();
                nameIndex = getColNumByHeader(header, new String[] { "名称", "データ名" });
                positionIndex = getColNumByHeader(header, new String[] { "形状(WKT)" });
            }

            while (sc.hasNextLine()) {
                var spot = new Spot(sc.nextLine(), nameIndex, positionIndex);
                spots.add(spot);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return spots;
    }

    public static void main(String[] args) {
        String dirPath = "./data";
        List<Path> files;

        try {
            files = Files.list(Path.of(dirPath)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        var spots = new ArrayList<Spot>();

        // ファイルごとにスポットを取得
        for (Path file : files) {
            try {
                spots.addAll(getSpotsByFile(file));
            } catch (FileNotFoundException e) {
                System.out.println("ファイル読み込めませんでした");
            }
        }

        Spot ait = new Spot("愛知工業大学", 35.1834122, 137.1130419);

        // ソート
        Collections.sort(spots, new Comparator<Spot>() {
            @Override
            public int compare(Spot s1, Spot s2) {
                return Double.compare(s1.getDistance(ait), s2.getDistance(ait));
            }
        });

        // 書き込み
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("TouristSpot.csv"), Charset.defaultCharset())) {
            bw.write("緯度情報,経度情報,愛工大からの距離,データ名");

            for (Spot spot : spots) {
                bw.write(spot.toCSVLine(ait));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
