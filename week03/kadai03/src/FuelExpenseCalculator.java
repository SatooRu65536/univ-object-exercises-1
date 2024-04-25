public class FuelExpenseCalculator {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        Car car = new Car();
        car.fuelEfficiency = 2.5;

        do {
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
