package jp.ac.ait.k23075;

import java.util.ArrayList;
import java.util.List;

public class UniqueString extends ArrayPrint implements IKadai08_3 {
    public static void main(String[] args) {
        String[] list_1 = { "A", "B", "B", "B", "C" };
        printList(new UniqueString().getUniqueList(List.of(list_1)));

        String[] list_2 = { "A", "A", "A", "A", "A" };
        printList(new UniqueString().getUniqueList(List.of(list_2)));

        String[] list_3 = { "A", "B", "C", "D", "E" };
        printList(new UniqueString().getUniqueList(List.of(list_3)));
    }

    public List<String> getUniqueList(List<String> targetList) {
        List<String> uniqueList = new ArrayList<>();

        outside_loop: for (String s : targetList) {
            int count = 0;
            for (String t : targetList) {
                if (s.equals(t)) {
                    count++;
                }
                if (count > 2) {
                    continue outside_loop;
                }
            }

            uniqueList.add(s);
        }

        return uniqueList;
    }
}
