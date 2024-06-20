package jp.ac.ait.k23075;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NonUniqueElements extends ArrayPrint implements IKadai08_4 {
    public static void main(String[] args) {
        Integer[][] int_lists = { //
                { 1, 2, 3, 1, 3 }, //
                { 1, 2, 3, 4, 5 }, //
                { 5, 5, 5, 5, 5 }, //
                { 10, 9, 10, 10, 9, 8 } //
        };

        for (Integer[] int_list : int_lists) {
            List<Integer> list = new LinkedList<>(Arrays.asList(int_list));

            new NonUniqueElements().convert(list);
            printList(list);
        }
    }

    public void convert(List<Integer> targetList) {
        Iterator<Integer> its = targetList.iterator();

        while (its.hasNext()) {
            Integer n = its.next();

            int count = 0;
            for (Integer m : targetList) {
                if (n.equals(m)) {
                    count++;
                }
            }

            if (count == 1) {
                its.remove();
            }
        }
    }
}
