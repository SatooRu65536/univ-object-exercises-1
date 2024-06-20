package jp.ac.ait.k23075;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDifference extends ArrayPrint implements IKadai08_5 {
    public static void main(String[] args) {
        ListDifference kadai5 = new ListDifference();

        List<Integer> list1_1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2_1 = Arrays.asList(3, 4, 6);
        List<Integer> output_1 = kadai5.find(list1_1, list2_1);
        printList(output_1);
        // output: [1, 2, 5]

        List<Integer> list1_2 = Arrays.asList(1, 2, 2, 2, 3);
        List<Integer> list2_2 = Arrays.asList(3, 3, 3, 3);
        List<Integer> output_2 = kadai5.find(list1_2, list2_2);
        printList(output_2);
        // output: [1, 2, 2, 2]

        List<String> list1_3 = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> list2_3 = Arrays.asList("banana", "date");
        List<String> output_3 = kadai5.find(list1_3, list2_3);
        printList(output_3);
        // output: ["apple", "cherry"]
    }

    public <T> List<T> find(List<T> list1, List<T> list2) {
        var targetList = new ArrayList<>(list1);
        var its = targetList.iterator();

        while (its.hasNext()) {
            var element = its.next();
            if (list2.contains(element)) {
                its.remove();
            }
        }

        return targetList;
    }
}
