### Các Hàm và Cú Pháp So Sánh, Sắp Xếp trong Java

Trong Java, có nhiều cách để thực hiện so sánh và sắp xếp các đối tượng. Dưới đây là các phương pháp phổ biến nhất:

---

## 1. **Interface Comparable**
- **Mục đích**: Sắp xếp tự nhiên (natural ordering)
- **Cách dùng**: Lớp cần implement interface `Comparable<T>`

```java
public class BankAccount implements Comparable<BankAccount> {
    // ...
    @Override
    public int compareTo(BankAccount other) {
        return Double.compare(this.balance, other.balance);
    }
}

// Sử dụng:
Arrays.sort(accounts);  // Sắp xếp tự động dùng compareTo
```

**Ưu điểm**:
- Đơn giản khi chỉ có 1 cách sắp xếp mặc định
- Không cần tạo comparator riêng

---

## 2. **Interface Comparator**
- **Mục đích**: Sắp xếp tùy chỉnh (multiple sorting criteria)
- **Cách dùng**: Tạo lớp riêng hoặc dùng anonymous class

### Cách 1: Anonymous Class
```java
Arrays.sort(accounts, new Comparator<BankAccount>() {
    @Override
    public int compare(BankAccount a1, BankAccount a2) {
        return a1.getAccountHolder().compareTo(a2.getAccountHolder());
    }
});
```

### Cách 2: Lambda Expression (Java 8+)
```java
Arrays.sort(accounts, (a1, a2) -> 
    a1.getAccountHolder().compareTo(a2.getAccountHolder()));
```

### Cách 3: Comparator.comparing()
```java
Arrays.sort(accounts, Comparator.comparing(BankAccount::getAccountHolder));
```

**Ưu điểm**:
- Linh hoạt với nhiều tiêu chí sắp xếp
- Có thể sắp xếp theo nhiều trường

---

## 3. **Các phương thức hữu ích của Comparator**

### a. Sắp xếp theo nhiều tiêu chí
```java
Arrays.sort(accounts, Comparator
    .comparing(BankAccount::getAccountHolder)
    .thenComparingDouble(BankAccount::getBalance));
```

### b. Sắp xếp ngược
```java
Arrays.sort(accounts, Comparator
    .comparing(BankAccount::getBalance).reversed());
```

### c. Xử lý null values
```java
Arrays.sort(accounts, Comparator
    .nullsFirst(Comparator.comparing(BankAccount::getAccountHolder)));
```

---

## 4. **Các hàm sắp xếp phổ biến**

### a. Với Mảng
```java
// Sắp xếp nguyên thủy
int[] numbers = {5, 2, 9};
Arrays.sort(numbers);

// Sắp xếp đối tượng
BankAccount[] accounts = {...};
Arrays.sort(accounts, comparator);
```

### b. Với Collections
```java
List<BankAccount> accountList = new ArrayList<>();
Collections.sort(accountList, comparator);

// Java 8+
accountList.sort(comparator);
```

---

## 5. **Quy tắc compare() quan trọng**
Khi implement `compare()` hoặc `compareTo()`, phải tuân thủ:
1. **Tính nhất quán**: `a.compareTo(b) = -b.compareTo(a)`
2. **Bắc cầu**: Nếu `a > b` và `b > c` thì `a > c`
3. **Đối xứng**: `a.compareTo(b) = 0` thì `b.compareTo(a) = 0`

---

## 6. **Ví dụ áp dụng cho BankAccount**

### Sắp xếp theo số dư tăng dần
```java
Arrays.sort(accounts, Comparator.comparingDouble(BankAccount::getBalance));
```

### Sắp xếp theo tên chủ tài khoản (A-Z) rồi đến số dư (giảm dần)
```java
Arrays.sort(accounts, Comparator
    .comparing(BankAccount::getAccountHolder)
    .thenComparing(Comparator.comparingDouble(BankAccount::getBalance).reversed()));
```

### Sắp xếp ngẫu nhiên
```java
Arrays.sort(accounts, (a, b) -> ThreadLocalRandom.current().nextInt(-1, 2));
```

---

## 7. **Performance Considerations**
- `Arrays.sort()`: Sử dụng QuickSort cho nguyên thủy, MergeSort cho đối tượng
- Độ phức tạp trung bình: O(n log n)
- Với dữ liệu lớn, có thể xem xử dụng `parallelSort()`

```java
Arrays.parallelSort(accounts);  // Sắp xếp song song
```

---

## Kết Luận
| Phương pháp | Use Case | Ưu điểm | Nhược điểm |
|-------------|----------|---------|------------|
| **Comparable** | Sắp xếp mặc định | Đơn giản | Chỉ 1 cách sắp xếp |
| **Comparator** | Sắp xếp tùy chỉnh | Linh hoạt | Code dài hơn |
| **Lambda** | Java 8+ | Ngắn gọn | Khó debug |

Chọn phương pháp phù hợp tùy theo nhu cầu ứng dụng và phiên bản Java đang sử dụng.
