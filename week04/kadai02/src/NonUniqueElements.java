public class NonUniqueElements {
    public IntCollector convert(IntCollector intCollector) {
        IntCollector newIntCollector = new IntCollector();

        int[] array = intCollector.getArray();
        for (int value : array) {
            if (intCollector.countOf(value) > 1) {
                newIntCollector.add(value);
            }
        }

        return newIntCollector;
    }

    public static void main(String[] args) {
        test(new IntCollector(new int[] { 1, 2, 3, 1, 3 }));
        test(new IntCollector(new int[] { 1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 5, 5 }));
        test(new IntCollector(new int[] { 1, 2, 3, 4, 5 }));
        test(new IntCollector(new int[] { 5, 5, 5, 5, 5, 5 }));
        test(new IntCollector(new int[] { 10, 9, 10, 10, 9, 8 }));
        test(new IntCollector(new int[] { 1, -1, 2, 2, -2, -2 }));
    }

    private static void test(IntCollector intCollector) {
        NonUniqueElements nonUniqueElements = new NonUniqueElements();
        IntCollector result = nonUniqueElements.convert(intCollector);

        System.out.println("==========");
        intCollector.print();
        result.print();
    }
}
