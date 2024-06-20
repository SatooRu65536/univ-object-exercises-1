package jp.ac.ait.k23075;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import jp.ac.ait.oop1.section09.IStudent;
import jp.ac.ait.oop1.section09.IStudentsSorter;

public class StudentsSorter implements IStudentsSorter {
    List<IStudent> students;

    public StudentsSorter(List<IStudent> students) {
        this.students = new LinkedList<>(students);
    }

    @Override
    public List<IStudent> getStudents() {
        return students;
    }

    @Override
    public void setStudents(List<IStudent> students) {
        this.students = new LinkedList<>(students);
    }

    @Override
    public List<IStudent> sortByTotalCreditsEarnedAsc() {
        var students = getStudents();

        Collections.sort(students, new Comparator<IStudent>() {
            @Override
            public int compare(IStudent o1, IStudent o2) {
                return o1.getTotalCreditsEarned() - o2.getTotalCreditsEarned();
            }
        });

        return students;
    }

    @Override
    public List<IStudent> sortByTotalCreditsEarnedDsc() {
        var students = getStudents();

        Collections.sort(students, new Comparator<IStudent>() {
            @Override
            public int compare(IStudent o1, IStudent o2) {
                return o2.getTotalCreditsEarned() - o1.getTotalCreditsEarned();
            }
        });

        return students;
    }
}
