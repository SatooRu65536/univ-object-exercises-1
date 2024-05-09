public class Fibonacci {
    public IntCollector get(int n) {
        IntCollector collector = new IntCollector(new int[] { 0, 1 });

        while (true) {
            int[] array = collector.getArray();
            int next = array[array.length - 1] + array[array.length - 2];

            if (next > n) {
                break;
            }

            collector.add(next);
        }

        return collector;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        IntCollector collector = fibonacci.get(100);

        int[] array = collector.getArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
