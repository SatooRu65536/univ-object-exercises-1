package jp.ac.ait.k23075;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz extends ArrayPrint implements IKadai08_2 {
    public static void main(String[] args) {
        Integer[] list_1 = { 1, 2, 3, 4, 5 };
        printList(new FizzBuzz().getConverted(Arrays.asList(list_1)));

        Integer[] list_2 = { 1, 2, 4 };
        printList(new FizzBuzz().getConverted(Arrays.asList(list_2)));

        Integer[] list_3 = { 12, 13, 14, 15, 16 };
        printList(new FizzBuzz().getConverted(Arrays.asList(list_3)));

        Integer[] list_4 = { 3, 30, 300 };
        printList(new FizzBuzz().getConverted(Arrays.asList(list_4)));

        Integer[] list_5 = {};
        printList(new FizzBuzz().getConverted(Arrays.asList(list_5)));
    }

    public List<String> getConverted(List<Integer> targetList) {
        List<String> convertList = new ArrayList<>();

        for (Integer i : targetList) {
            if (i % 15 == 0) {
                convertList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                convertList.add("Fizz");
            } else if (i % 5 == 0) {
                convertList.add("Buzz");
            } else {
                convertList.add(i.toString());
            }
        }

        return convertList;
    }
}
