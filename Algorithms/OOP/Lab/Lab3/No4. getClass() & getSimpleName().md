Câu lệnh `System.out.print(animal.getClass().getSimpleName() + " - ");` trong Java có nghĩa là:

### **Giải thích chi tiết**:
1. **`animal.getClass()`**:
   - Trả về đối tượng `Class` (lớp mô tả thông tin về kiểu dữ liệu) của đối tượng `animal`.
   - Ví dụ: Nếu `animal` là 1 con sư tử (đối tượng của lớp `Lion`), sẽ trả về `Lion.class`.

2. **`.getSimpleName()`**:
   - Là phương thức của lớp `Class`, trả về tên lớp **không bao gồm package**.
   - Ví dụ: 
     - `Lion.class.getSimpleName()` → `"Lion"`
     - `com.zoo.Lion.class.getSimpleName()` → vẫn là `"Lion"`

3. **`+ " - "`**:
   - Nối chuỗi `" - "` vào sau tên lớp để tạo định dạng hiển thị.

4. **`System.out.print()`**:
   - In kết quả ra màn hình **không xuống dòng**.

### **Ví dụ cụ thể**:
```java
Animal animal = new Lion("Simba", 5);
System.out.print(animal.getClass().getSimpleName() + " - ");
```
Kết quả in ra: 
```
Lion - 
```

### **Tại sao dùng trong Zoo Management System?**
- Để hiển thị **loại động vật** (tên lớp) trước các thông tin khác.
- Giúp phân biệt các loại động vật khác nhau trong danh sách:
  ```
  Lion - Name: Simba, Age: 5
  Whale - Name: Bruce, Age: 10
  ```

### **Lưu ý**:
- Nếu `animal` là `null`, sẽ ném ra `NullPointerException`.
- Khác với `.getName()` (trả về tên đầy đủ bao gồm package), `.getSimpleName()` chỉ lấy tên ngắn gọn.

Bạn có thể thay thế bằng cách hard-code tên lớp nếu muốn, nhưng dùng `getSimpleName()` sẽ linh hoạt hơn khi đổi tên lớp.
