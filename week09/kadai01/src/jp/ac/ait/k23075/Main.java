package jp.ac.ait.k23075;

import java.util.List;

import jp.ac.ait.oop1.section09.Grade;

public class Main {
    private static void testStudent() {
        var s1 = new Student("s1", "佐藤", List.of(
                new Grade("bbb", 1, 'D'),
                new Grade("図画工作", 1, 'C'),
                new Grade("物理", 2, 'B'),
                new Grade("道徳", 2, 'Q'),
                new Grade("aaa", 1, 'D'),
                new Grade("数学", 2, 'A')));

        System.out.println(s1.toString());

        System.out.println("\n--- getGradesSortByRatingDsc ---");
        System.out.println("\n・ソート前");
        s1.getGrades().forEach(g -> System.out.println(g.getSubject() + ": " + g.getMyRating()));

        System.out.println("\n・ソート後");
        s1.getGradesSortByRatingDsc().forEach(g -> System.out.println(g.getSubject() + ": " + g.getMyRating()));

        System.out.println("\n--- getGradesFilterByRating ---");
        System.out.print("\n・評価A: ");
        s1.getGradesFilterByRating('A').forEach(g -> System.out.print(g.getSubject() + ":" + g.getMyRating() + ", "));
        System.out.print("\n・評価B: ");
        s1.getGradesFilterByRating('B').forEach(g -> System.out.print(g.getSubject() + ":" + g.getMyRating() + ", "));
        System.out.print("\n・評価C: ");
        s1.getGradesFilterByRating('C').forEach(g -> System.out.print(g.getSubject() + ":" + g.getMyRating() + ", "));
        System.out.print("\n・評価D: ");
        s1.getGradesFilterByRating('D').forEach(g -> System.out.print(g.getSubject() + ":" + g.getMyRating() + ", "));
        System.out.print("\n・評価F: ");
        s1.getGradesFilterByRating('F').forEach(g -> System.out.print(g.getSubject() + ":" + g.getMyRating() + ", "));
        System.out.print("\n・評価Q: ");
        s1.getGradesFilterByRating('Q').forEach(g -> System.out.print(g.getSubject() + ":" + g.getMyRating() + ", "));

        System.out.println("\n\n--- getGradesFilterByCreditsEarned ---");
        System.out.print("\n・単位取得済み: ");
        s1.getGradesFilterByCreditsEarned()
                .forEach(g -> System.out.print(g.getSubject() + ":" + g.getMyRating() + ", "));

        System.out.println("\n\n--- getTotalCreditsEarned ---");
        System.out.println("\n・単位取得数: " + s1.getTotalCreditsEarned());
    }

    private static void testStudentsSorter() {
        var s1 = new Student("s1", "佐藤", List.of(
                new Grade("日本史A", 1, 'S')));
        var s2 = new Student("s2", "安藤", List.of(
                new Grade("日本史B", 2, 'A')));
        var s3 = new Student("s3", "近藤", List.of(
                new Grade("日本史C", 3, 'B')));
        var s4 = new Student("s4", "sudo", List.of(
                new Grade("日本史D", 4, 'Q')));

        var studentsSorter = new StudentsSorter(List.of(s2, s1, s4, s3));

        System.out.println("\n・ソート前");
        studentsSorter.getStudents().forEach(s -> System.out.println(s.toString()));

        System.out.println("\n・ソート後(ASC)");
        studentsSorter.sortByTotalCreditsEarnedAsc().forEach(s -> System.out.println(s.toString()));

        System.out.println("\n・ソート後(DSC)");
        studentsSorter.sortByTotalCreditsEarnedDsc().forEach(s -> System.out.println(s.toString()));
    }

    public static void main(String[] args) {
        System.out.println("=== Student Class Test ===");
        testStudent();

        System.out.println("\n=== StudentsSorter Class Test ===");
        testStudentsSorter();
    }
}
