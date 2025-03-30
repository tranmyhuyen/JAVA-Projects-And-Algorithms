package Lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read all inputs as doubles to maintain precision
        int horsepower = scanner.nextInt();
        String wheelBrand = scanner.next();
        int wheelSize = scanner.nextInt();
        double fuelTankCapacity = scanner.nextDouble();  // Changed to nextDouble()
        double fuelTankLevel = scanner.nextDouble();     // Changed to nextDouble()
        
        Engine engine = new Engine(horsepower);
        Wheel wheel = new Wheel(wheelBrand, wheelSize);
        FuelTank fuelTank = new FuelTank(fuelTankCapacity, fuelTankLevel);
        Car car = new Car(engine, wheel, fuelTank);
        
        // Test outputs
        System.out.println(car.getCarHorsepower());
        System.out.println(car.getWheelBrand());
        System.out.println(car.getFuelLevel());
        
        double distance = scanner.nextDouble();  // Changed to nextDouble()
        car.drive(distance);
        System.out.println(car.getFuelLevel());
        
        double amount = scanner.nextDouble();   // Changed to nextDouble()
        car.refuel(amount);
        System.out.println(car.getFuelLevel());
    }
}
