public class Car {
    double fuelEfficiency;
    double totalMileage;
    double expendedFuel;

    public static void main(String[] args) {
        Car car = new Car();

        car.fuelEfficiency = 2.5;

        System.out.println(car.run(100));
        System.out.println(car.getInfo());
    }

    public double run(double mileage) {
        // 今回の走行で消費した燃料
        double expendFuel = mileage / fuelEfficiency;

        totalMileage += mileage;
        expendedFuel += expendFuel;

        return expendFuel;
    }

    public String getInfo() {
        return String.format("走行距離:%.2fkm 消費燃料:%.2fL", totalMileage, expendedFuel);
    }
}
