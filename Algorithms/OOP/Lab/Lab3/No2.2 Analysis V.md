# Phân tích Hệ thống Quản lý Sở thú bằng OOP

Dưới đây là hướng dẫn chi tiết cách phân tích hệ thống quản lý sở thú bằng lập trình hướng đối tượng (OOP) và cách áp dụng các nguyên lý OOP vào bài toán thực tế.

## 1. Cách tiếp cận phân tích hệ thống

### Bước 1: Xác định các thực thể chính
- **Động vật (Animal)**: Lớp trừu tượng cơ sở
- **Thú (Mammal)**, **Chim (Bird)**, **Bò sát (Reptile)**: Các lớp con
- **Cá voi (Whale)**: Lớp đặc biệt kế thừa từ Thú
- **Giao diện Bơi được (Swimmable)**
- **Sở thú (Zoo)**: Lớp quản lý

### Bước 2: Nhận diện các nguyên lý OOP áp dụng

| Nguyên lý OOP       | Biểu hiện trong hệ thống |
|---------------------|--------------------------|
| **Tính trừu tượng** | Lớp Animal chứa phương thức trừu tượng |
| **Đóng gói**        | Thuộc tính private + getter/setter |
| **Kế thừa**         | Mammal/Bird/Reptile kế thừa Animal |
| **Đa hình**         | Gọi makeSound() cho từng loại động vật |
| **Giao diện**       | Swimmable chỉ cho động vật biết bơi |

## 2. Phân tích chi tiết từng thành phần

### Lớp Animal (Trừu tượng)
```java
abstract class Animal {
    protected String name;
    protected int age;
    protected String species;
    
    // Phương thức trừu tượng
    public abstract String makeSound();
    public abstract String move();
}
```
**Phân tích**:
- Là lớp cơ sở trừu tượng
- Định nghĩa thuộc tính chung cho mọi động vật
- Yêu cầu lớp con phải triển khai các hành vi cơ bản

### Các lớp con cụ thể
**Ví dụ lớp Mammal**:
```java
class Mammal extends Animal {
    private boolean isDomestic;
    
    @Override
    public String makeSound() {
        return "Roar!";
    }
}
```
**Đặc điểm**:
- Thêm thuộc tính riêng (isDomestic)
- Triển khai phương thức theo đặc thù loài

### Giao diện Swimmable
```java
interface Swimmable {
    void swim();
}
```
**Ứng dụng**:
- Chỉ những loài biết bơi mới triển khai
- Giúp mở rộng linh hoạt không phá vỡ hệ thống cũ

## 3. Cách phân tích đa hình trong hệ thống

**Ví dụ trong lớp Zoo**:
```java
public void showAnimals() {
    for (Animal animal : animals) {
        System.out.println(animal.makeSound()); // Đa hình
        if (animal instanceof Swimmable) {
            ((Swimmable)animal).swim(); // Kiểm tra giao diện
        }
    }
}
```

**Giải thích**:
1. `animal.makeSound()`: Tự động gọi phương thức đúng của từng loài
2. `instanceof`: Kiểm tra khả năng bơi trước khi gọi

## 4. Bài học thiết kế quan trọng

1. **Nguyên tắc SOLID áp dụng**:
   - **Single Responsibility**: Mỗi lớp chỉ làm 1 việc
   - **Open/Closed**: Dễ mở rộng, không sửa code cũ
   - **Liskov Substitution**: Lớp con thay thế được lớp cha
   - **Interface Segregation**: Tách giao diện nhỏ
   - **Dependency Inversion**: Phụ thuộc vào abstraction

2. **Kinh nghiệm thực tế**:
   - Dùng abstract class khi có logic chung cần chia sẻ
   - Dùng interface khi cần đa kế thừa hành vi
   - Đặt tên phương thức rõ ràng, thể hiện đúng hành vi

## 5. Cách mở rộng hệ thống

**Thêm loài mới (Ví dụ: Cá)**
```java
class Fish extends Animal implements Swimmable {
    private int finCount;
    
    @Override
    public String makeSound() {
        return "Blub!";
    }
    
    @Override
    public void swim() {
        System.out.println("Swim with fins");
    }
}
```

**Thêm tính năng mới**:
1. Tạo interface `Flyable` cho các loài biết bay
2. Thêm lớp `Penguin` kế thừa `Bird` nhưng không bay được

## 6. Lỗi thường gặp và cách khắc phục

| Lỗi | Nguyên nhân | Cách sửa |
|-----|------------|----------|
| ClassCastException | Ép kiểu sai | Dùng instanceof kiểm tra trước |
| Thiếu triển khai phương thức | Quên override | Đánh dấu @Override |
| Logic trùng lặp | Không tận dụng kế thừa | Đưa lên lớp cha |

Bài tập này giúp hiểu sâu cách áp dụng OOP vào các hệ thống thực tế, từ đó phát triển thành các hệ thống phức tạp hơn như quản lý nhân sự, hệ thống bán hàng...
