// Engine class implementation
class Engine {
    private int horsepower;

    public Engine(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }
}

// Wheel class implementation
class Wheel {
    private String brand;
    private int size;

    public Wheel(String brand, int size) {
        this.brand = brand;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public int getSize() {
        return size;
    }
}

// FuelTank class implementation
class FuelTank {
    private double capacity;
    private double fuelLevel;

    public FuelTank(double capacity, double fuelLevel) {
        this.capacity = capacity;
        this.fuelLevel = fuelLevel;
    }

    public void refuel(double amount) {
        fuelLevel = Math.min(fuelLevel + amount, capacity);
    }

    public void consumeFuel(double amount) {
        fuelLevel = Math.max(fuelLevel - amount, 0);
    }

    public double getFuelLevel() {
        return fuelLevel;
    }
}

// Car class implementation
class Car {
    private Engine engine;
    private Wheel[] wheels;
    private FuelTank fuelTank;

    public Car(Engine engine, Wheel wheel, FuelTank fuelTank) {
        this.engine = engine;
        this.wheels = new Wheel[4];
        // Initialize all 4 wheels with the same brand and size
        for (int i = 0; i < 4; i++) {
            this.wheels[i] = wheel;
        }
        this.fuelTank = fuelTank;
    }

    public int getCarHorsepower() {
        return engine.getHorsepower();
    }

    public String getWheelBrand() {
        return wheels[0].getBrand();
    }

    public double getFuelLevel() {
        return fuelTank.getFuelLevel();
    }

    public void drive(double distance) {
        double consumptionRate;
        int hp = engine.getHorsepower();

        if (hp < 100) {
            consumptionRate = 0.1;
        } else if (hp < 200) {
            consumptionRate = 0.15;
        } else {
            consumptionRate = 0.2;
        }

        double fuelConsumed = consumptionRate * distance;
        fuelTank.consumeFuel(fuelConsumed);
    }

    public void refuel(double amount) {
        fuelTank.refuel(amount);
    }
}
