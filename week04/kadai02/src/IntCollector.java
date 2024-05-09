public class IntCollector {
    private int array[];

    public IntCollector() {
        array = new int[0];
    }

    public IntCollector(int[] values) {
        array = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = values[i];
        }
    }

    public int[] getArray() {
        return this.array;
    }

    public void setArray(int[] values) {

    }

    public void add(int value) {
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[array.length] = value;
        array = newArray;
    }

    public int countOf(int value) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count++;
            }
        }
        return count;
    }

    public int indexOf(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        if (index < 0 || index >= array.length) {
            return;
        }

        int[] newArray = new int[array.length - 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("\n=== 引数あり ===");
        IntCollector intCollector = new IntCollector(new int[] { 1, 2, 3, 4, 5, 1, 2, 3, 4 });
        test(intCollector);

        System.out.println("\n=== 引数なし ===");
        IntCollector intCollector2 = new IntCollector();
        test(intCollector2);
    }

    private static void test(IntCollector intCollector) {
        System.out.println("------ print() ------");
        intCollector.print();

        System.out.println("------ getArray() ------");
        int[] array = intCollector.getArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        int addValue = 65536;
        System.out.println("------ add(%d) ------".formatted(addValue));
        intCollector.add(addValue);
        intCollector.print();

        int countValue = 3;
        System.out.println("------ countOf(%d) ------".formatted(countValue));
        System.out.println(intCollector.countOf(countValue));

        int indexOfValue = 3;
        System.out.println("------ indexOf(%d) ------".formatted(indexOfValue));
        System.out.println(intCollector.indexOf(indexOfValue));

        int removeIndex = 2;
        System.out.println("------ remove(%d) ------".formatted(removeIndex));
        intCollector.remove(removeIndex);
        intCollector.print();

        int[] values = new int[] { 1, 2, 3, 4, 5 };
        System.out.println("------ setArray(%s) ------".formatted(java.util.Arrays.toString(values)));
        intCollector.setArray(values);
        intCollector.print();
    }
}
