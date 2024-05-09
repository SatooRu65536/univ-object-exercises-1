public class TimesTable {
    public int width;
    public int height;
    public int array[][];

    public TimesTable(int width, int height) {
        this.width = width;
        this.height = height;
        this.array = new int[height][width];

        for (int w = 0; w < this.width; w++) {
            for (int h = 0; h < this.height; h++) {
                this.array[h][w] = (w + 1) * (h + 1);
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int[][] getArray() {
        return this.array;
    }

    public void print() {
        for (int h = 0; h < this.height; h++) {
            System.out.print("|");
            for (int w = 0; w < this.width; w++) {
                System.out.print(this.array[h][w]);
                if (w < this.width - 1) {
                    System.out.print("|");
                }
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        test(new TimesTable(4, 3));
        test(new TimesTable(3, 4));
        test(new TimesTable(0, 0));
        test(new TimesTable(1, 1));
        test(new TimesTable(9, 9));
    }

    private static void test(TimesTable table) {
        System.out.println("\n===== %d x %d =====".formatted(table.width, table.height));
        int width = table.getWidth();
        int height = table.getHeight();
        int[][] array = table.getArray();

        System.out.println("-----Width-----");
        System.out.println(width);

        System.out.println("-----Height-----");
        System.out.println(height);

        System.out.println("-----Array-----");
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                System.out.print(array[h][w]);
                if (w < width - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        System.out.println("-----print-----");
        table.print();
    }
}
