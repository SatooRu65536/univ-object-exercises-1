public class FuelExpenseCalculator {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        Car car = new Car();
        car.fuelEfficiency = 2.5;

        do {
            System.out.print("走行距離(km)を入力. 終了する場合は end を入力: ");
            String input = scanner.nextLine();
            if (input.equals("end"))
                break;

            double mileage = Double.parseDouble(input);
            car.run(mileage);
            System.out.println(car.getInfo());
        } while (true);

        scanner.close();
    }
}
