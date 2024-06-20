package jp.ac.ait.k23075;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import jp.ac.ait.oop1.section09.Grade;
import jp.ac.ait.oop1.section09.IStudent;
import jp.ac.ait.oop1.section09.StudentBase;

public class Student extends StudentBase implements IStudent {
    public Student(String studentId, String name, List<Grade> grades) {
        setStudentId(studentId);
        setName(name);
        setGrades(new LinkedList<>(grades));
    }

    @Override
    public List<Grade> getGradesSortByRatingDsc() {
        var grades = getGrades();

        Collections.sort(grades, new Comparator<Grade>() {
            @Override
            public int compare(Grade o1, Grade o2) {
                if (o1.getMyRating() - o2.getMyRating() > 0) {
                    return 1;
                } else if (o1.getMyRating() == o2.getMyRating()) {
                    // 同じ評価の場合は科目名をUnicode順の昇順で並び替え
                    return o1.getSubject().compareTo(o2.getSubject());
                } else {
                    return -1;
                }
            }
        });

        return grades;
    }

    @Override
    public List<Grade> getGradesFilterByRating(char rating) {
        var grades = getGrades();
        var result = new LinkedList<Grade>();

        for (var grade : grades) {
            if (grade.getMyRating() == rating) {
                result.add(grade);
            }
        }

        return result;
    }

    @Override
    public List<Grade> getGradesFilterByCreditsEarned() {
        var grades = getGrades();
        var result = new LinkedList<Grade>();

        for (var grade : grades) {
            switch (grade.getMyRating()) {
                case 'Q':
                case 'F':
                    break;
                default:
                    result.add(grade);
                    break;
            }
        }

        return result;
    }

    @Override
    public int getTotalCreditsEarned() {
        int total = 0;

        for (var grade : getGrades()) {
            total += grade.getMyCredit();
        }

        return total;
    }
}
