package jp.ac.ait.k23075;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci extends ArrayPrint implements IKadai08_1 {
    public static void main(String[] args) {
        Integer[] max_values = { 10000, 0, -1, 1, 2 };

        for (Integer max_value : max_values) {
            List<Integer> list = new Fibonacci().get(max_value);
            printList(list);
        }
    }

    public List<Integer> get(int max_value) {
        List<Integer> list = new ArrayList<>();

        if (max_value < 0) {
            return list;
        }

        list.add(0);
        if (max_value == 0) {
            return list;
        }
        list.add(1);

        int next = list.get(list.size() - 1) + list.get(list.size() - 2);
        do {
            list.add(next);
            next = list.get(list.size() - 1) + list.get(list.size() - 2);
        } while (next <= max_value);

        return list;
    }
}
