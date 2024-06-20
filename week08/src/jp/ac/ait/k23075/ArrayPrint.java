package jp.ac.ait.k23075;

import java.util.List;

public class ArrayPrint {
    protected static void printList(List<?> list) {
        var its = list.iterator();

        System.out.print("[");
        while (its.hasNext()) {
            System.out.print(its.next());
            if (its.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
