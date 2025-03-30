# Zoo Management System 🦁🐍🐋

## Problem Description  
You are tasked with creating a **Zoo Management System** using Object-Oriented Programming principles. The system should model different types of animals, including **mammals, birds, and reptiles**.  

### 📌 Requirements  

### 🦁 **Animal Class (Abstract)**
- `name` (String) - Name of the animal.
- `age` (int) - Age of the animal.
- `species` (String) - Species of the animal.
- `makeSound()` (abstract method) - Each subclass implements this.
- `move()` (abstract method) - Each subclass implements this.

### 🏊 **Swimmable Interface**
- `swim()` - Implemented by animals that can swim.

### 🦍 **Mammal Class (Extends Animal)**
- `isDomestic` (boolean) - Determines if it's a domestic or wild mammal.
- Implements:
  - `makeSound()` → `"Roar!"`
  - `move()` → `"Walk"`

### 🦅 **Bird Class (Extends Animal)**
- `wingSpan` (double) - Wingspan in meters.
- Implements:
  - `makeSound()` → `"Chirp!"`
  - `move()` → `"Fly"`

### 🐍 **Reptile Class (Extends Animal)**
- `isVenomous` (boolean) - Determines if it's venomous.
- Implements:
  - `makeSound()` → `"Hiss!"`
  - `move()` → `"Crawl"`

### 🐳 **Whale Class (Extends Mammal & Implements Swimmable)**
- Implements:
  - `makeSound()` → `"Whup!"`
  - `move()` → `"Swim"`
  - `swim()` → `"Swim in the ocean"`

### 🏛️ **Zoo Class**
- `ArrayList<Animal>` to store animals.
- `addAnimal(Animal animal)` - Adds an animal.
- `showAnimals()` - Displays animals and their behaviors.

---

## 📝 **Example Output**

Mammal - Name: Simba, Age: 5, Species: Panthera leo Roar! Walk

Whale - Name: Bruce, Age: 10, Species: Sperm Whup! Swim Swim in the ocean


---

## 📌 **Testing Code**
```java
public class TestZoo {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Mammal lion = new Mammal("Simba", 5, "Panthera leo", false);
        Bird eagle = new Bird("Skyler", 3, "Aquila chrysaetos", 2.5);
        Reptile snake = new Reptile("Viper", 2, "Viperidae", true);
        Whale whale = new Whale("Bruce", 10, "Sperm", false);

        zoo.addAnimal(lion);
        zoo.addAnimal(eagle);
        zoo.addAnimal(snake);
        zoo.addAnimal(whale);

        zoo.showAnimals();
    }
}

