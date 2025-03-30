# Zoo Management System Implementation 🐘🦜🐊

Here's the complete Java implementation of the Zoo Management System following all the specified requirements:

## Core Classes Implementation

### 1. Abstract Animal Class
```java
abstract class Animal {
    protected String name;
    protected int age;
    protected String species;

    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public abstract String makeSound();
    public abstract String move();

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getSpecies() { return species; }
}
```

### 2. Swimmable Interface
```java
interface Swimmable {
    void swim();
}
```

### 3. Mammal Class
```java
class Mammal extends Animal {
    private boolean isDomestic;

    public Mammal(String name, int age, String species, boolean isDomestic) {
        super(name, age, species);
        this.isDomestic = isDomestic;
    }

    @Override
    public String makeSound() {
        return "Roar!";
    }

    @Override
    public String move() {
        return "Walk";
    }

    public boolean isDomestic() {
        return isDomestic;
    }
}
```

### 4. Bird Class
```java
class Bird extends Animal {
    private double wingSpan;

    public Bird(String name, int age, String species, double wingSpan) {
        super(name, age, species);
        this.wingSpan = wingSpan;
    }

    @Override
    public String makeSound() {
        return "Chirp!";
    }

    @Override
    public String move() {
        return "Fly";
    }

    public double getWingSpan() {
        return wingSpan;
    }
}
```

### 5. Reptile Class
```java
class Reptile extends Animal {
    private boolean isVenomous;

    public Reptile(String name, int age, String species, boolean isVenomous) {
        super(name, age, species);
        this.isVenomous = isVenomous;
    }

    @Override
    public String makeSound() {
        return "Hiss!";
    }

    @Override
    public String move() {
        return "Crawl";
    }

    public boolean isVenomous() {
        return isVenomous;
    }
}
```

### 6. Whale Class
```java
class Whale extends Mammal implements Swimmable {
    public Whale(String name, int age, String species, boolean isDomestic) {
        super(name, age, species, isDomestic);
    }

    @Override
    public String makeSound() {
        return "Whup!";
    }

    @Override
    public String move() {
        return "Swim";
    }

    @Override
    public void swim() {
        System.out.println("Swim in the ocean");
    }
}
```

### 7. Zoo Management Class
```java
import java.util.ArrayList;

class Zoo {
    private ArrayList<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void showAnimals() {
        for (Animal animal : animals) {
            // Display animal type and basic info
            System.out.print(animal.getClass().getSimpleName() + " - ");
            System.out.print("Name: " + animal.getName() + ", ");
            System.out.print("Age: " + animal.getAge() + ", ");
            System.out.print("Species: " + animal.getSpecies() + " ");

            // Display animal-specific behaviors
            System.out.print(animal.makeSound() + " ");
            System.out.print(animal.move());

            // If animal can swim, display swimming behavior
            if (animal instanceof Swimmable) {
                System.out.print(" ");
                ((Swimmable)animal).swim();
            } else {
                System.out.println();
            }
        }
    }
}
```

## Test Program
```java
public class TestZoo {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        
        // Create different animal instances
        Mammal lion = new Mammal("Simba", 5, "Panthera leo", false);
        Bird eagle = new Bird("Skyler", 3, "Aquila chrysaetos", 2.5);
        Reptile snake = new Reptile("Viper", 2, "Viperidae", true);
        Whale whale = new Whale("Bruce", 10, "Sperm", false);

        // Add animals to the zoo
        zoo.addAnimal(lion);
        zoo.addAnimal(eagle);
        zoo.addAnimal(snake);
        zoo.addAnimal(whale);

        // Display all animals and their behaviors
        zoo.showAnimals();
    }
}
```

## Key Features Demonstrated

1. **Abstraction**: Animal class defines common structure while leaving implementation to subclasses
2. **Encapsulation**: All fields are private with public getters
3. **Inheritance**: Mammal, Bird, Reptile extend Animal; Whale extends Mammal
4. **Polymorphism**: Zoo manages different animal types through base Animal reference
5. **Interface Implementation**: Whale implements Swimmable interface
6. **Dynamic Method Dispatch**: Correct methods called at runtime based on actual object type

## Example Output
```
Mammal - Name: Simba, Age: 5, Species: Panthera leo Roar! Walk
Bird - Name: Skyler, Age: 3, Species: Aquila chrysaetos Chirp! Fly
Reptile - Name: Viper, Age: 2, Species: Viperidae Hiss! Crawl
Whale - Name: Bruce, Age: 10, Species: Sperm Whup! Swim Swim in the ocean
```

This implementation fully satisfies all the requirements while demonstrating proper OOP principles and design patterns.
