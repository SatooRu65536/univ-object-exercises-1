public class MethodsPractice {
    public static void main(String[] args) {
        MethodsPractice app = new MethodsPractice();

        // printCurrency
        System.out.println("-- 1. printCurrency ----------");
        app.printCurrency(123.456789); // 1.23
        app.printCurrency(0); // 0.00
        app.printCurrency(-1); // -1.00
        app.printCurrency(1.334); // 1.33
        app.printCurrency(1.335); // 1.34

        // add
        System.out.println("\n-- 2. add ----------");
        System.out.println(app.add(5, 7)); // 12
        System.out.println(app.add(-2, 5)); // 3
        System.out.println(app.add(0, 0)); // 0

        // division
        System.out.println("\n-- 3. division ----------");
        System.out.println(app.division(5, 7));
        System.out.println(app.division(10, 3));
        System.out.println(app.division(10, -2));

        // getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything
        System.out.println("\n-- 4. getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything ----------");
        System.out.println(app.getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything());
    }

    public void printCurrency(double num) {
        System.out.printf("%.2f\n", num);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public double division(int a, int b) {
        return (double) a / b;
    }

    public String getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything() {
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
        }
        return "42";
    }
}
