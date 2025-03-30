Đúng là về mặt kỹ thuật, bạn **có thể** dùng class thường thay vì abstract class, nhưng abstract class mang lại những lợi ích thiết kế quan trọng. Hãy cùng phân tích chi tiết:

### **1. Về mặt kỹ thuật: Cả 2 cách đều chạy được**
```java
// Cách 1: Dùng class thường
class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

// Cách 2: Dùng abstract class
abstract class Animal {
    public abstract void makeSound();
}
```

### **2. Tại sao nên dùng abstract class?**
#### **Ưu điểm vượt trội:**
| **Tình huống**              | **Class thường**                          | **Abstract Class**                     |
|-----------------------------|------------------------------------------|----------------------------------------|
| **Ép buộc lớp con triển khai** | ❌ Không ép buộc (có thể quên override) | ✅ Bắt buộc phải override (nếu không sẽ lỗi biên dịch) |
| **Thể hiện ý đồ thiết kế**  | Không rõ ràng                           | Rõ ràng: "Đây là lớp khung, không dùng trực tiếp" |
| **Bảo vệ logic hệ thống**   | Có thể vô tình khởi tạo lớp cha vô nghĩa | ❌ Không thể `new Animal()` → An toàn  |
| **Hỗ trợ đa hình**          | Phải tự kiểm soát override              | Compiler kiểm tra giúp bạn             |

#### **Ví dụ thực tế:**
Giả sử bạn thiết kế hệ thống hình học:
```java
// ❌ Cách không dùng abstract - Dễ phát sinh lỗi
class Shape {
    public double getArea() {
        return 0; // Trả về giá trị vô nghĩa!
    }
}

// ✅ Cách dùng abstract - An toàn
abstract class Shape {
    public abstract double getArea(); // Ép buộc lớp con phải tính toán
}
```

### **3. Khi nào NÊN dùng class thường?**
Chỉ khi:
- Lớp đó **có thể khởi tạo** và **có ý nghĩa độc lập**
- Bạn **không muốn ép buộc** lớp con phải override phương thức

### **4. Lý do sâu hơn từ góc độ thiết kế**
1. **Nguyên lý LSP (Liskov Substitution)**:
   - Abstract class giúp đảm bảo mọi lớp con đều **tuân thủ hợp đồng** (contract) của lớp cha.

2. **Tránh Anti-pattern**:
   - Không dùng abstract class có thể dẫn đến **lớp cha trả về giá trị mặc định vô nghĩa** (như `return 0` trong ví dụ Shape).

3. **Tính rõ ràng trong kiến trúc**:
   - Abstract class như một tài liệu thiết kế, nói rõ: *"Đây là khung, hãy triển khai chi tiết"*.

### **5. Benchmark hiệu năng (không đáng kể)**
|               | Class thường | Abstract Class |
|---------------|-------------|----------------|
| **Tốc độ**    | Như nhau    | Như nhau       |
| **Bộ nhớ**    | Như nhau    | Như nhau       |

→ Không ảnh hưởng hiệu năng!

### **Kết luận:**
✔ **Dùng abstract class** khi bạn muốn:
- Định nghĩa **khung bắt buộc**
- Ép buộc **tính nhất quán** giữa các lớp con
- Ngăn chặn **khởi tạo không mong muốn**

✔ **Dùng class thường** khi:
- Lớp đó **đủ hoàn chỉnh** để dùng trực tiếp
- Không cần **ràng buộc** với lớp con

**Ví dụ cuối cùng:**
```java
// ❌ Thiết kế không tốt:
class Database {
    public void connect() { 
        // Lớp con có thể quên override
    }
}

// ✅ Thiết kế tốt:
abstract class Database {
    public abstract void connect(); // Ép buộc triển khai
}

class MySQL extends Database {
    @Override
    public void connect() { ... } // Phải implement
}
```

→ Abstract class giống như **bản thiết kế lao động**, đảm bảo mọi công nhân (lớp con) phải tuân theo quy trình!
