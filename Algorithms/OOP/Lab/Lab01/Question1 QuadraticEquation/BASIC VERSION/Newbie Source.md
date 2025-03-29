Nếu viết code theo cách thông thường (không dùng exception và các nguyên tắc OOP nghiêm ngặt), lớp `QuadraticEquation` có thể được triển khai đơn giản như sau:

### Phiên bản đơn giản (cách thông thường)
```java
package Lab1;

public class QuadraticEquation {
    public double a, b, c;  // Không cần private
    
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double getDiscriminant() {
        return b*b - 4*a*c;
    }
    
    public void calculateRoots() {
        if (a == 0) {
            System.out.println("Đây không phải phương trình bậc 2!");
            return;
        }
        
        double delta = getDiscriminant();
        
        if (delta < 0) {
            System.out.println("Phương trình vô nghiệm");
        } 
        else if (delta == 0) {
            double x = -b/(2*a);
            System.out.println("Nghiệm kép x = " + x);
        } 
        else {
            double x1 = (-b + Math.sqrt(delta))/(2*a);
            double x2 = (-b - Math.sqrt(delta))/(2*a);
            System.out.println("Hai nghiệm phân biệt:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
}
```

### Cách sử dụng đơn giản
```java
public class Main {
    public static void main(String[] args) {
        QuadraticEquation eq = new QuadraticEquation(1, -5, 6);
        eq.calculateRoots();
        
        // Có thể truy cập trực tiếp các hệ số
        System.out.println("Hệ số a: " + eq.a);
    }
}
```

### So sánh với phiên bản áp dụng OOP đầy đủ

| Đặc điểm               | Cách thông thường                          | Cách áp dụng OOP đầy đủ               |
|------------------------|--------------------------------------------|----------------------------------------|
| **Đóng gói dữ liệu**   | Không (dùng `public` fields)               | Có (dùng `private` fields + getter)    |
| **Xử lý lỗi**          | In ra thông báo trực tiếp                  | Ném exception                          |
| **Tính linh hoạt**     | Kết quả chỉ để in ra màn hình              | Trả về mảng số để xử lý tiếp           |
| **Tái sử dụng**        | Khó do logic tính toán và UI gắn liền      | Dễ dàng do tách biệt logic và hiển thị |
| **Bảo mật**           | Dữ liệu có thể bị thay đổi từ bên ngoài    | Dữ liệu được bảo vệ                    |

### Ưu điểm của cách thông thường
1. **Dễ hiểu** cho người mới học
2. **Ít code hơn** do bỏ qua các kiểm tra phức tạp
3. **Nhanh** khi làm bài tập nhỏ

### Nhược điểm
1. **Khó bảo trì** khi mở rộng
2. **Dễ phát sinh lỗi** do không kiểm soát được dữ liệu
3. **Khó tái sử dụng** code vì logic gắn chặt với UI

### Khi nào nên dùng cách này?
- Khi làm bài tập nhỏ, không cần mở rộng sau này
- Khi mới học lập trình và chưa cần quan tâm đến các nguyên tắc phức tạp
- Khi viết code nhanh để test ý tưởng

Tuy nhiên, trong các dự án thực tế, cách áp dụng OOP đầy đủ vẫn được khuyến khích vì tính bền vững và dễ bảo trì về sau.
